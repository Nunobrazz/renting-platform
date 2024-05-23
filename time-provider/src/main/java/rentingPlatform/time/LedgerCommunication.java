package rentingPlatform.time;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.util.UUID.randomUUID;
import static rentingPlatform.time.TimeProvider.debug;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import com.daml.ledger.javaapi.data.*;
import com.daml.ledger.javaapi.data.codegen.Update;
import com.daml.ledger.rxjava.DamlLedgerClient;

import rentingPlatform.codegen.time.clock.DateClock;
import rentingPlatform.codegen.time.clock.DateClockUpdateEvent;
import rentingPlatform.codegen.time.lifecycle.evolve.Evolve;


public class LedgerCommunication {
  
  public static final String APP_ID = "RentingPlatform";

  public String party;
  public DamlLedgerClient client;
  
  public static final AtomicReference<LedgerOffset> acsOffset = new AtomicReference<>(LedgerOffset.LedgerBegin.getInstance()); 
  public AtomicLong idCounter = new AtomicLong(0);

  public DateClock.ContractId dateClockCid;

  public Evolve.ContractId evolveCid;



  // creates 6 threads
  LedgerCommunication(String ledgerhost, int ledgerApiPort, String partyArg) {
    debug("LEDGER COMMUNICATION", "");

    party = partyArg;

    // Create a client object to access services on the ledger.
    client = DamlLedgerClient.newBuilder(ledgerhost, ledgerApiPort).build();

    // Connects to the ledger and runs initial validation.
    client.connect();

    debug("Connceted to: {}", client.getLedgerId());

  }

  // everyday advance clock by 1 day and probes better to create a thread that always probes updates to evolveclockCid var
  public void advanceClock(long days) {

    debug ("Advancing Clock {} day...", days);

    var update = dateClockCid.exerciseAdvance(days);
    var result = submit(client, party, update);    // NewClock and DateClockEvent

    dateClockCid = result.exerciseResult; 

  }
  
  
  private void processClockEvent(DateClockUpdateEvent.Contract event) {

    debug("Clock Event: {}", event.data.eventDate.toString());

    var update = evolveCid.exerciseProcessEvent(event.id); 
    submit(client, party, update);  // Maybe print if some payment occured
  }

  public void getCurrentState() {
    DateClock.Contract dateClock = client
        .getActiveContractSetClient()
        .getActiveContracts(DateClock.contractFilter(), Collections.singleton(party), true)
        .blockingFirst()
        .activeContracts
        .get(0);

    // up to date with the ledger
    LocalDate ledgerDate = dateClock.data.clockDate;
    LocalDate today = LocalDate.now(); 

    long days = ChronoUnit.DAYS.between(ledgerDate, today);

    debug("Ledger Date: {}", ledgerDate);
    debug("Today: {}", today);
    debug("Days: {}", days);

    dateClockCid = dateClock.id;

    advanceClock(days);
    
  }
  


  public void activateClockUpdatEvents(){
    client
            .getTransactionsClient()
            .getTransactions(
                DateClockUpdateEvent.contractFilter(), acsOffset.get(), Collections.singleton(party), true)
            .forEach(
                t -> { 
                  Event lastEvent = t.getEvents().get(t.getEvents().size() - 1); // last event of that contract cannot be an archive
                  assert (lastEvent instanceof CreatedEvent);

                  CreatedEvent createdEvent = (CreatedEvent) lastEvent;
                  DateClockUpdateEvent.Contract updateEventContract = DateClockUpdateEvent.Contract.fromCreatedEvent(createdEvent);
                  processClockEvent(updateEventContract);
                });
  }


// Acrescentar sincronizacao entre cada Time Provider
  public void activateEvolveContractProbing() {
    
    client
            .getTransactionsClient()
            .getTransactions(          // Be sure that this is respects the order of events in blockchain
                Evolve.contractFilter(), acsOffset.get(), Collections.singleton(party), true) 
            .forEach(
                t -> {
                  Event lastEvent = t.getEvents().get(t.getEvents().size() - 1); // last event of that contract cannot be an archive
                  assert (lastEvent instanceof CreatedEvent);
                  CreatedEvent createdEvent = (CreatedEvent) lastEvent;
                  Evolve.Contract evolveContract = Evolve.Contract.fromCreatedEvent(createdEvent);
                  evolveCid = evolveContract.id;
                });
  }

  



  private static <U> U submit(DamlLedgerClient client, String party, Update<U> update) {
    UpdateSubmission<U> updateSubmission =
        UpdateSubmission.create(APP_ID, randomUUID().toString(), update).withActAs(party);

    return client.getCommandClient().submitAndWaitForResult(updateSubmission).blockingGet();
  }

  public void close() throws Exception {
    client.close();
  }

}
