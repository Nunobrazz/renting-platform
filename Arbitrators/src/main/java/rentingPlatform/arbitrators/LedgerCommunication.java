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
    LedgerCommunication(String ledgerhost, int ledgerApiPort, String individualParty) {
  
      this.individualParty = individualParty;

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
                  System.out.println(contract);
                  long id = InvitationsIdCounter.getAndIncrement();
                  if (contract.data.miDetails.nArbitrators > contract.data.confirmed.map.size()){ // Not complete invitations only
                    invitations.put(id, contract.data);
                    invitationIds.put(id, contract.id);
                  }
                });
          });
    }

    public void getMIReportCurrentState(){
      client
      .getActiveContractSetClient()
      .getActiveContracts(MIReport.contractFilter(), Collections.singleton(individualParty), true)
      .blockingForEach(
          response -> {
            response.offset.ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
            response.activeContracts.forEach(
                contract -> {
                  long id = MIReportsIdCounter.getAndIncrement();
                    miRep.put(id, contract.data);
                    miRepIds.put(id, contract.id);
                });
          });
    }

    public void getVotationCurrentState(){
      client
      .getActiveContractSetClient()
      .getActiveContracts(Votation.contractFilter(), Collections.singleton(individualParty), true)
      .blockingForEach(
          response -> {
            response.offset.ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
            response.activeContracts.forEach(
                contract -> {
                  long id = miRepIds.inverse().get(contract.data.miReportCid); // Syncronize Votations with MI Reports
                  votations.put(id, contract.data);
                  votationIds.put(id, contract.id);
                });
          });
      //MIReportsIdCounter.set(0);
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

                    if (contract.data.miDetails.nArbitrators > contract.data.confirmed.map.size()){   // Not complete invitations only
                      invitations.put(id, contract.data);
                      invitationIds.put(id, contract.id);
                      System.out.printf("New invitation update.\n");
                    }
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event;
                    long id =
                        invitationIds.inverse().get(new InviteArbitrators.ContractId(archivedEvent.getContractId()));
                    invitations.remove(id);
                    invitationIds.remove(id);
                    System.out.printf("One invitation was terminated.\n");
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
                  System.out.printf("Event\n");
                  System.out.printf(event.toString());
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    long id = MIReportsIdCounter.getAndIncrement();
                    MIReport.Contract contract = MIReport.Contract.fromCreatedEvent(createdEvent);
                    miRep.put(id, contract.data);
                    miRepIds.put(id, contract.id);
                    System.out.printf("You have been added to a new MI!\n");
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event; 
                    MIReport.ContractId archivedCid = new MIReport.ContractId(archivedEvent.getContractId());
                    System.out.println("Archiving: ");
                    System.out.println(archivedCid);
                    long id =
                        miRepIds.inverse().get(archivedCid); // this get maybe is recieveing a null
                    miRep.remove(id);
                    miRepIds.remove(id);
                    System.out.printf("One MI Report was archived!\n");
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
                    System.out.printf("One votation has been created!\n");
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event; 
                    long id =
                          votationIds.inverse().get(new Votation.ContractId(archivedEvent.getContractId()));
                    votations.remove(id);
                    votationIds.remove(id);
                    System.out.printf("One votation has been terminated.\n");
                  }
                }
                });
    }

    public void searchInvitations(){
      
      long choice = io.invitationChoice(invitations, invitationIds);
      
      if (choice == -1)
        return;

      var update = invitationIds.get(choice).exerciseAccept(individualParty);
      submit(client, individualParty, update);   
        
      System.out.printf("Waiting for end of invitation process.");  
    }



    public void createVotation(){

      long id = io.miChoice(miRep, miRepIds);
            
      if (id == -1)
        return;
      String visitDetails = io.askVisitDetails();
      Responsability vote = io.askVote();

      long cost = io.askCost();
      LocalDate assessmentDate = io.askAssessmentDate();
      LocalDate reparationDate = io.askReparationDate();

      var update = miRepIds.get(id).exerciseCreateVotation(individualParty, visitDetails, vote, cost, assessmentDate, reparationDate);
      submit(client, individualParty, update);   
    }
    
    public void submitVote(){

      long id = io.miChoice(miRep, miRepIds); //  must submit visit details
      if (id == -1)
      return;
      Responsability vote = io.askVote();
      
      if (votations.get(id).alreadyVoted.map.size() + 1 == votations.get(id).miDetails.nArbitrators){
        
        var update = votationIds.get(id).exerciseVote(individualParty, vote);
        var res = submit(client, individualParty, update).exerciseResult;  

        var finalize = new Votation.ContractId(res.contractId).exerciseFinalizeVotation(individualParty);
        submit(client, individualParty, finalize);
      }
      else{
        var update = votationIds.get(id).exerciseVote(individualParty, vote);
        submit(client, individualParty, update);
      }
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
