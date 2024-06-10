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
import rentingPlatform.codegen.platform.leaseagreement.modelmi.MIReport;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.Votation;
import rentingPlatform.codegen.platform.types.mi.AssessmentDetails;
import rentingPlatform.codegen.platform.types.mi.Responsability;


public class LedgerCommunication {
    public static final String APP_ID = "RentingPlatform";

    public String individualParty;
    public String operatorParty;

    public DamlLedgerClient client;
    
    public static final AtomicReference<LedgerOffset> acsOffset = new AtomicReference<>(LedgerOffset.LedgerBegin.getInstance()); 
    public AtomicLong InvitationsIdCounter = new AtomicLong(0); 
    public AtomicLong MIReportsIdCounter = new AtomicLong(0); 

    public IO io;

    // This is not the correct data strucutre a list or map is enough but must allow remove by value and not just index or key
    ConcurrentHashMap<Long, InviteArbitrators> invitations = new ConcurrentHashMap<>();
    BiMap<Long, InviteArbitrators.ContractId> invitationIds = Maps.synchronizedBiMap(HashBiMap.create());

    ConcurrentHashMap<Long, MIReport> miRep = new ConcurrentHashMap<>();
    BiMap<Long, MIReport.ContractId> miRepIds = Maps.synchronizedBiMap(HashBiMap.create());

    ConcurrentHashMap<Long, Votation> votations = new ConcurrentHashMap<>();
    BiMap<Long, Votation.ContractId> votationIds = Maps.synchronizedBiMap(HashBiMap.create());



    // creates 6 threads
    LedgerCommunication(String ledgerhost, int ledgerApiPort, String individualParty, String operatorParty) {
  
      this.individualParty = individualParty;
      this.operatorParty = operatorParty;

      // Create a client object to access services on the ledger.
      client = DamlLedgerClient.newBuilder(ledgerhost, ledgerApiPort).build();
  
      // Connects to the ledger and runs initial validation.
      client.connect();
      debug("Connceted to: {}", client.getLedgerId());

      io = new IO();
    }


    public void getInvitationsCurrentState(){
      client
      .getActiveContractSetClient()
      .getActiveContracts(InviteArbitrators.contractFilter(), Collections.singleton(individualParty), true)
      .blockingForEach(
          response -> {
            response.offset.ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
            response.activeContracts.forEach(
                contract -> {
                  long id = InvitationsIdCounter.getAndIncrement();
                  if (contract.data.miDetails.nArbitrators > contract.data.invited.map.size()){ // Not complete invitations only
                    invitations.put(id, contract.data);
                    invitationIds.put(id, contract.id);
                  }
                });
          });
      InvitationsIdCounter.set(0);
    }

    public void probeInvitations(){
      
      client
            .getTransactionsClient()
            .getTransactions(
                InviteArbitrators.contractFilter(), acsOffset.get(), Collections.singleton(individualParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    long id = InvitationsIdCounter.getAndIncrement();
                    InviteArbitrators.Contract contract = InviteArbitrators.Contract.fromCreatedEvent(createdEvent);
                    if (contract.data.miDetails.nArbitrators > contract.data.invited.map.size()){   // Not complete invitations only
                      invitations.put(id, contract.data);
                      invitationIds.put(id, contract.id);
                      System.out.printf("New invitation update.");
                    }
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event;
                    long id =
                        invitationIds.inverse().get(new InviteArbitrators.ContractId(archivedEvent.getContractId()));
                    invitations.remove(id);
                    invitationIds.remove(id);
                    System.out.printf("One invitation was terminated.");
                  }
                }
                });
    }


    public void probeMIReports(){
      
      client
            .getTransactionsClient()
            .getTransactions(  
                MIReport.contractFilter(), acsOffset.get(), Collections.singleton(individualParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    long id = MIReportsIdCounter.getAndIncrement();
                    MIReport.Contract contract = MIReport.Contract.fromCreatedEvent(createdEvent);
                    miRep.put(id, contract.data);
                    miRepIds.put(id, contract.id);
                    System.out.printf("You have been added to a new MI!");
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event; 
                    long id =
                        miRepIds.inverse().get(new MIReport.ContractId(archivedEvent.getContractId()));
                    miRep.remove(id);
                    miRepIds.remove(id);
                    System.out.printf("One MI Report was archived!");
                  }
                }
                });

    }


    public void probeVotations(){
      
      client
            .getTransactionsClient()
            .getTransactions(  
                Votation.contractFilter(), acsOffset.get(), Collections.singleton(individualParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    Votation.Contract contract = Votation.Contract.fromCreatedEvent(createdEvent);
                    long id = miRepIds.inverse().get(contract.data.miReportCid); // Syncronize Votations with MI Reports
                    votations.put(id, contract.data);
                    votationIds.put(id, contract.id);
                    System.out.printf("One votation has been created!");
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event; 
                    long id =
                          votationIds.inverse().get(new Votation.ContractId(archivedEvent.getContractId()));
                    votations.remove(id);
                    votationIds.remove(id);
                    System.out.printf("One votation has been terminated.");
                  }
                }
                });
    }

    public void searchInvitations(){
      
      long choice = io.invitationChoice(invitations, invitationIds);

      var update = invitationIds.get(choice).exerciseAccept(individualParty);
      submit(client, individualParty, update);   
        
      System.out.printf("Waiting for end of invitation process.");  
    }



    public void createVotation(){

      long miId = io.miChoice(miRep, miRepIds);
      String visitDetails = io.askVisitDetails();
      AssessmentDetails assessment = io.askAssessmentDetails();

      var update = miRepIds.get(miId).exerciseCreateVotation(individualParty, visitDetails, assessment);
      submit(client, individualParty, update);   
    }
    
    public void submitVote(){
      long miId = io.miChoice(miRep, miRepIds);

      Responsability vote = io.askVote();

      var update = votationIds.get(miId).exerciseVote(individualParty, vote);
      submit(client, individualParty, update);   

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
