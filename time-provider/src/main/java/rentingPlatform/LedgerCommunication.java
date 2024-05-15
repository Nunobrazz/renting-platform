package rentingPlatform;

import java.util.*;
import static java.util.UUID.randomUUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import org.slf4j.Logger;
import com.daml.ledger.javaapi.data.*;
import com.daml.ledger.javaapi.data.CommandsSubmission;
import com.daml.ledger.javaapi.data.codegen.Update;
import com.daml.ledger.rxjava.DamlLedgerClient;
import com.daml.ledger.rxjava.LedgerClient;
import org.slf4j.LoggerFactory;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import rentingPlatform.codegen.time.clock.DateClock;
import rentingPlatform.codegen.time.clock.DateClockUpdateEvent;
import rentingPlatform.codegen.time.lifecycle.evolve.Evolve;
import static rentingPlatform.TimeProvider.debug;

public class LedgerCommunication {
  
  public static final String APP_ID = "RentingPlatform";

  public String party;
  public DamlLedgerClient client;
  
  public static final AtomicReference<LedgerOffset> acsOffset = new AtomicReference<>(LedgerOffset.LedgerBegin.getInstance()); 
  public AtomicLong idCounter = new AtomicLong(0);

  public DateClock.ContractId dateClockCid;
  public Evolve.ContractId evolveCid;


  public ConcurrentHashMap<Long, Evolve> evolveData = new ConcurrentHashMap<>();
  public BiMap<Long, Evolve.ContractId> evolveCids = Maps.synchronizedBiMap(HashBiMap.create());

  
  LedgerCommunication(String ledgerhost, int ledgerApiPort, String partyArg) {
    
    party = partyArg;

    // Create a client object to access services on the ledger.
    client = DamlLedgerClient.newBuilder(ledgerhost, ledgerApiPort).build();

    // Connects to the ledger and runs initial validation.
    client.connect();

    debug("ledger-id: {}", client.getLedgerId());

  }


  public void initializeContracts() {
    client
        .getActiveContractSetClient()
        .getActiveContracts(DateClock.contractFilter(), Collections.singleton(party), true)
        .blockingForEach(
            response -> {
              response.offset.ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
              response.activeContracts.forEach( // only exists one 
                contract -> {
                  dateClockCid = contract.id;
                });
          });
  
    idCounter.set(0);

    client
        .getActiveContractSetClient()
        .getActiveContracts(Evolve.contractFilter(), Collections.singleton(party), true)
        .blockingForEach(
            response -> {
              response.offset.ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
              response.activeContracts.forEach(
                  contract -> {
                    long id = idCounter.getAndIncrement();
                    evolveData.put(id, contract.data);
                    evolveCids.put(id, contract.id);
                  });
          });


    debug("evolveCids: {}", evolveCids.toString());
    debug("evolveData: {}", evolveData.toString());

  }

  
  // everyday advance clock by 1 day and probes better to create a thread that always probes updates to evolveclockCid var
  public void advanceClock(int days) {

    var update = dateClockCid.exerciseAdvance((long) days);
    var result = submit(client, party, update); // NewClock and DateClockEvent
    
    dateClockCid = result.exerciseResult._1;

    processClockEvent(result.exerciseResult._2);

    probeEvolveContracts();

  }

  private void processClockEvent(DateClockUpdateEvent.ContractId eventCid) {
    Evolve.ContractId evolveCid = evolveCids.get((long) 0);
    var update = evolveCid.exerciseProcessEvent(eventCid); // this is the type of result
    submit(client, party, update); // NewClock and DateClockEvent
  }


  private void probeEvolveContracts () {
    client
            .getTransactionsClient()
            .getTransactions(           // does this create a specifi thread ??
                Evolve.contractFilter(), acsOffset.get(), Collections.singleton(party), true) // verbose
            .forEach(
                t -> {
                  for (Event event : t.getEvents()) {
                    if (event instanceof CreatedEvent) {
                      CreatedEvent createdEvent = (CreatedEvent) event;
                      Evolve.Contract evolveContract = Evolve.Contract.fromCreatedEvent(createdEvent);
                      evolveCid = evolveContract.id;
                    } 
                  } // Devo fazer mais verificações ?
                });
  }

  



  private static <U> U submit(DamlLedgerClient client, String party, Update<U> update) {
    UpdateSubmission<U> updateSubmission =
        UpdateSubmission.create(APP_ID, randomUUID().toString(), update).withActAs(party);

    return client.getCommandClient().submitAndWaitForResult(updateSubmission).blockingGet();
  }


}
