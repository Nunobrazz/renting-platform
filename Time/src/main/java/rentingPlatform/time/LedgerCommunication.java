package rentingPlatform.time;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.util.UUID.randomUUID;
import static rentingPlatform.time.TimeProvider.debug;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import com.daml.ledger.javaapi.data.*;
import com.daml.ledger.javaapi.data.codegen.Update;
import com.daml.ledger.rxjava.DamlLedgerClient;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import rentingPlatform.codegen.time.clock.DateClock;
import rentingPlatform.codegen.time.clock.DateClockUpdateEvent;
import rentingPlatform.codegen.time.lifecycle.evolve.Evolve;


public class LedgerCommunication {
  
  public static final String APP_ID = "RentingPlatform";

  public String timeProviderParty;
  public String lifecyclerParty;

  public DamlLedgerClient client;
  

  public static final AtomicReference<LedgerOffset> acsOffset = new AtomicReference<>(LedgerOffset.LedgerBegin.getInstance()); 
  public AtomicLong dateClocksIdCounter = new AtomicLong(0);

  
  public DateClock.Contract dateClock;
  public Evolve.Contract evolve;



  // creates 6 threads
  LedgerCommunication(String ledgerhost, int ledgerApiPort, String timeProviderParty, String lifecyclerParty) {
    this.timeProviderParty = timeProviderParty;
    this.lifecyclerParty = lifecyclerParty;

    // Create a client object to access services on the ledger.
    client = DamlLedgerClient.newBuilder(ledgerhost, ledgerApiPort).build();

    // Connects to the ledger and runs initial validation.
    client.connect();
    debug("Connceted to: {}", client.getLedgerId());

  }

  public void getCurrentState() {
    dateClock = client
        .getActiveContractSetClient()
        .getActiveContracts(DateClock.contractFilter(), Collections.singleton(timeProviderParty), true)
        .blockingFirst()
        .activeContracts
        .get(0);
    
    System.out.printf("Current Date: %s\n", dateClock.data.clockDate.toString());

    evolve = client
        .getActiveContractSetClient()
        .getActiveContracts(Evolve.contractFilter(), Collections.singleton(lifecyclerParty), true)
        .blockingFirst()
        .activeContracts
        .get(0);
    
    System.out.printf("Current Evolve Cid: %s\n", evolve.id.toString());

  }
  

  public void probeDateClocks(){ // Probe because other party can update too
      
      client
            .getTransactionsClient()
            .getTransactions(  
                DateClock.contractFilter(), acsOffset.get(), Collections.singleton(timeProviderParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    dateClock = DateClock.Contract.fromCreatedEvent(createdEvent);
                    System.out.printf("New Date: %s\n", dateClock.data.clockDate.toString());
                  } 
                }
              });
    }


  public void probeEvolve() {
    
    client
            .getTransactionsClient()
            .getTransactions(         
                Evolve.contractFilter(), acsOffset.get(), Collections.singleton(lifecyclerParty), true) 
            .forEach(
                t -> {
                  for (Event event : t.getEvents()) {
                    if (event instanceof CreatedEvent) {
                      CreatedEvent createdEvent = (CreatedEvent) event;
                      evolve = Evolve.Contract.fromCreatedEvent(createdEvent);
                      System.out.printf("\nNew LA added to Evolve contract.\n");
                    } 
                  }
                });
  }
  
  // everyday advance clock by 1 day and probes better to create a thread that always probes updates to evolve
  public void advanceClock() {

    System.out.printf("First in providers: %s\n",dateClock.data.providers.get(0));
    System.out.printf("timeProviderParty: %s\n", timeProviderParty);
    System.out.printf("length First in providers: %s\n",dateClock.data.providers.get(0).length());
    System.out.printf("length timeProviderParty: %s\n", timeProviderParty.length());
    System.out.printf("Verification is: %b\n", timeProviderParty.equals(dateClock.data.providers.get(0)));

    //if (dateClock.data.providers.get(0).equals(timeProviderParty)) { // should i keep this if or print exception
      
      System.out.printf("\nAdvancing date clock one day...\n");
            
      var update = dateClock.id.exerciseAdvance(timeProviderParty);
      var result = submit(client, timeProviderParty, update);    // NewClock and DateClockEvent
      

      System.out.printf("\nEvolve Cid: %s\n", evolve.id.toString());
      System.out.printf("\nresult.exerciseResult: %s\n", result.exerciseResult);
      
      DateClockUpdateEvent.ContractId updatedClockcid = result.exerciseResult;

      // Lifecycle payments
      var update1 = evolve.id.exerciseProcessEvent(updatedClockcid); 
      
      submit(client, lifecyclerParty, update1);  // Maybe print if some payment occured

   
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
