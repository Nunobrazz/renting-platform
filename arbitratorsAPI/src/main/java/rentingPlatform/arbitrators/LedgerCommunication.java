package rentingPlatform.arbitrators;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.util.UUID.randomUUID;
import static rentingPlatform.arbitrators.Arbitrator.debug;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import java.util.concurrent.ConcurrentHashMap;

import com.daml.ledger.javaapi.data.*;
import com.daml.ledger.javaapi.data.codegen.Update;
import com.daml.ledger.rxjava.DamlLedgerClient;

import rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.MI;
import rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.Request;
import rentingPlatform.codegen.platform.leaseagreement.arbitratorsservice.Service;

public class LedgerCommunication {
    public static final String APP_ID = "RentingPlatform";

    public String arbitratorParty;
    public String operatorParty;

    public DamlLedgerClient client;
    
    public Service.ContractId serviceCid;

    public static final AtomicReference<LedgerOffset> acsOffset = new AtomicReference<>(LedgerOffset.LedgerBegin.getInstance()); 
    public AtomicLong idCounter = new AtomicLong(0);

    public IO io;

    // This is not the correct data strucutre a list or map is enough but must allow remove by value and not just index or key
    ConcurrentHashMap<Long, InviteArbitrators> invitations = new ConcurrentHashMap<>();
    BiMap<Long, InviteArbitrators.ContractId> invitationsCids = Maps.synchronizedBiMap(HashBiMap.create());

    // creates 6 threads
    LedgerCommunication(String ledgerhost, int ledgerApiPort, String partyArg, String operatorArg) {
  
      arbitratorParty = partyArg;
      operatorParty = operatorArg;

      // Create a client object to access services on the ledger.
      client = DamlLedgerClient.newBuilder(ledgerhost, ledgerApiPort).build();
  
      // Connects to the ledger and runs initial validation.
      client.connect();
  
      debug("Connceted to: {}", client.getLedgerId());

      io = new IO();
    }

    public void joinService(){
      
      System.out.printf("Requesting to join service...");

      var requestCreate = Request.create(arbitratorParty, operatorParty);
      var result = submit(client, arbitratorParty, requestCreate);
      

      debug("Service Request result: {}", result.toString());
      debug("Waiting for operator approval...", "");

      Event event = client
            .getTransactionsClient() // it doesnt verify when its archived
            .getTransactions(Service.contractFilter(), acsOffset.get(), Collections.singleton(arbitratorParty), true)
            .blockingFirst()
            .getEvents()
            .get(0);
      assert (event instanceof CreatedEvent);
      
      CreatedEvent createEvent = (CreatedEvent) event;

      System.out.printf("Request Approved!");
      serviceCid = Service.Contract.fromCreatedEvent(createEvent).id;
      debug("Service id created: {}", serviceCid);
    }


    public void probeInvitations(){
      
      client
            .getTransactionsClient()
            .getTransactions(
                InviteArbitrators.contractFilter(), acsOffset.get(), Collections.singleton(arbitratorParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    long id = idCounter.getAndIncrement();
                    InviteArbitrators.Contract contract = InviteArbitrators.Contract.fromCreatedEvent(createdEvent);
                    invitations.put(id, contract.data);
                    invitationsCids.put(id, contract.id);
                    System.out.printf("New invitation created!");
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event; //verificar se este archived e meu
                    long id =
                        invitationsCids.inverse().get(new InviteArbitrators.ContractId(archivedEvent.getContractId()));
                    invitations.remove(id);
                    invitationsCids.remove(id);
                    System.out.printf("One invitation was archived!");
                  }
                }
                });
    }


    public void probeMI(){
      
      client
            .getTransactionsClient()
            .getTransactions(
                InviteArbitrators.contractFilter(), acsOffset.get(), Collections.singleton(arbitratorParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    long id = idCounter.getAndIncrement();
                    InviteArbitrators.Contract contract = InviteArbitrators.Contract.fromCreatedEvent(createdEvent);
                    invitations.put(id, contract.data);
                    invitationsCids.put(id, contract.id);
                    System.out.printf("New invitation created!");
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event; 
                    long id =
                        invitationsCids.inverse().get(new InviteArbitrators.ContractId(archivedEvent.getContractId()));
                    invitations.remove(id);
                    invitationsCids.remove(id);
                    System.out.printf("One invitation was archived!");
                  }
                }
                });
    }


    public void searchMI(){

      debug("invitationsCids : {}", invitationsCids.toString());  
      
      long choice = io.invitationChoice(invitations, invitationsCids);

      var update = invitationsCids.get(choice).exerciseAccept(arbitratorParty);
      submit(client, arbitratorParty, update);   
        
      System.out.printf("Waiting for end of invitation process...");  
  
    }



    public void createVotation(){
      System.out.printf("Not build."); 
    }
    
    public void submitVote(){
      System.out.printf("Not build."); 
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
