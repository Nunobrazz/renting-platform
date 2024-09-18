package rentingPlatform.arbitrators;

import java.util.*;
import java.time.LocalDate;

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

import rentingPlatform.codegen.platform.modelmi.InviteArbitrators;
import rentingPlatform.codegen.platform.modelmi.MIReport;
import rentingPlatform.codegen.platform.modelmi.Poll;
import rentingPlatform.codegen.platform.modelmi.CreatePoll;
import rentingPlatform.codegen.platform.modelmi.Vote;
import rentingPlatform.codegen.platform.types.mi.Responsability;


public class LedgerCommunication {
    public static final String APP_ID = "RentingPlatform";

    public String individualParty;

    public DamlLedgerClient client;
    
    public static final AtomicReference<LedgerOffset> acsOffset = new AtomicReference<>(LedgerOffset.LedgerBegin.getInstance()); 
    public AtomicLong invitationsIdCounter = new AtomicLong(0); 
    public AtomicLong miReportsIdCounter = new AtomicLong(0); 
    public AtomicLong pollsIdCounter = new AtomicLong(0); 

    public IO io;


    ConcurrentHashMap<Long, InviteArbitrators> invitations = new ConcurrentHashMap<>();
    BiMap<Long, InviteArbitrators.ContractId> invitationCids = Maps.synchronizedBiMap(HashBiMap.create());
    
    // Once arbitrators can see them can only be archived to create a Poll
    ConcurrentHashMap<Long, MIReport> miReports = new ConcurrentHashMap<>(); 
    BiMap<Long, MIReport.ContractId> miReportCids = Maps.synchronizedBiMap(HashBiMap.create());
    
    ConcurrentHashMap<Long, Poll> polls = new ConcurrentHashMap<>();
    BiMap<Long, Poll.ContractId> pollCids = Maps.synchronizedBiMap(HashBiMap.create());


    // creates 6 threads
    LedgerCommunication(String ledgerhost, int ledgerApiPort, String individualParty) {
  
      this.individualParty = individualParty;
      // Create a client object to access services on the ledger.
      client = DamlLedgerClient.newBuilder(ledgerhost, ledgerApiPort).build();
  
      // Connects to the ledger and runs initial validation.
      client.connect();
      debug("Connceted to: {}", client.getLedgerId());
      debug("Runing as: {}", individualParty );


      io = new IO();
      getInvitationsCurrentState();
      getMIReportCurrentState();
      getPollCurrentState();
      probeInvitations();
      probeMIReports();
      probePolls();
    }
    public String getIndividualParty(){
      return individualParty;
    }
    public ConcurrentHashMap<Long, InviteArbitrators> getInvitations(){
      return invitations;
    }    
    public ConcurrentHashMap<Long, MIReport> getAssignedMIReports(){
      return miReports;
    }    
    public ConcurrentHashMap<Long, Poll> getPolls(){
      return polls;
    }
    private void getInvitationsCurrentState(){
      client
      .getActiveContractSetClient()
      .getActiveContracts(InviteArbitrators.contractFilter(), Collections.singleton(individualParty), true)
      .blockingForEach(
          response -> {
            response.offset.ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
            response.activeContracts.forEach(
                contract -> {
                  long id = invitationsIdCounter.getAndIncrement();
                  if (contract.data.miDetails.nArbitrators > contract.data.confirmed.map.size()){ // Incomplete invitations only
                    invitations.put(id, contract.data);
                    invitationCids.put(id, contract.id);
                  }
                });
          });
    }

    private void getMIReportCurrentState(){
      client
      .getActiveContractSetClient()
      .getActiveContracts(MIReport.contractFilter(), Collections.singleton(individualParty), true)
      .blockingForEach(
          response -> {
            response.offset.ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
            response.activeContracts.forEach(
                contract -> {
                    long id = miReportsIdCounter.getAndIncrement();
                      miReports.put(id, contract.data);
                      miReportCids.put(id, contract.id);
                });
          });
    }

    private void getPollCurrentState(){
      client
      .getActiveContractSetClient()
      .getActiveContracts(Poll.contractFilter(), Collections.singleton(individualParty), true)
      .blockingForEach(
          response -> {
            response.offset.ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
            response.activeContracts.forEach(
                contract -> { 
                  long id = pollsIdCounter.getAndIncrement();
                  polls.put(id, contract.data);
                  pollCids.put(id, contract.id);
                });
          });
    }
    
    private void probeInvitations(){
      
      client
            .getTransactionsClient()
            .getTransactions(
                InviteArbitrators.contractFilter(), acsOffset.get(), Collections.singleton(individualParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    long id = invitationsIdCounter.getAndIncrement();
                    InviteArbitrators.Contract contract = InviteArbitrators.Contract.fromCreatedEvent(createdEvent);
                    // Incomplete invitations only without himself (verify containsKey in archived contracts)
                    if (contract.data.miDetails.nArbitrators > contract.data.confirmed.map.size() && !contract.data.confirmed.map.containsKey(individualParty)){   
                      invitations.put(id, contract.data);
                      invitationCids.put(id, contract.id);
                      System.out.printf("\nNew invitation update.\n"); //debug
                    }
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event;
                    InviteArbitrators.ContractId archivedContract = new InviteArbitrators.ContractId(archivedEvent.getContractId());
                    if (invitationCids.inverse().containsKey(archivedContract)){
                      long id = invitationCids.inverse().get(archivedContract);
                      invitations.remove(id);
                      invitationCids.remove(id);
                    }
                  }
                }
              });
    }

    private void probeMIReports(){
      
      client
            .getTransactionsClient()
            .getTransactions(  
                MIReport.contractFilter(), acsOffset.get(), Collections.singleton(individualParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    MIReport.Contract contract = MIReport.Contract.fromCreatedEvent(createdEvent);
                    long id = miReportsIdCounter.getAndIncrement();
                    miReports.put(id, contract.data);
                    miReportCids.put(id, contract.id);
                    System.out.printf("You have been added to a new MI!\n");
                  } 
                  else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event; 
                    MIReport.ContractId archivedContract = new MIReport.ContractId(archivedEvent.getContractId());
                    if (miReportCids.inverse().containsKey(archivedContract)){
                      long id = miReportCids.inverse().get(archivedContract);
                      miReports.remove(id);
                      miReportCids.remove(id);
                    }
                  }
                }
              });
    }

    private void probePolls(){
      
      client
            .getTransactionsClient()
            .getTransactions(  
                Poll.contractFilter(), acsOffset.get(), Collections.singleton(individualParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    Poll.Contract contract = Poll.Contract.fromCreatedEvent(createdEvent);
                    long id = pollsIdCounter.getAndIncrement();
                    polls.put(id, contract.data);
                    pollCids.put(id, contract.id);
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event; 
                    long id =
                          pollCids.inverse().get(new Poll.ContractId(archivedEvent.getContractId()));
                    polls.remove(id);
                    pollCids.remove(id);
                  }
                }
              });
    }

    public void acceptInvitation(long invitationId){
      var update = invitationCids.get(invitationId).exerciseAccept(individualParty);
      submit(client, individualParty, update);   
      System.out.printf("Waiting for the end of the Invitation process.");  
    }


    public void createPoll(CreatePoll createPoll, long miReportId){
      var update = miReportCids.get(miReportId).exerciseCreatePoll(createPoll);
      submit(client, individualParty, update);   
    }
    
    public void submitVote(Vote vote, long pollId){
      if (polls.get(pollId).alreadyVoted.map.containsKey(individualParty)){
        System.out.println("\nYou already participated in this Poll.");
      }
      else if (polls.get(pollId).alreadyVoted.map.size() + 1 == polls.get(pollId).miDetails.nArbitrators){
        
        var update = pollCids.get(pollId).exerciseVote(vote);
        var res = submit(client, individualParty, update).exerciseResult;  
        System.out.printf("Vote submitted sucessfully.\n");
        var finalize = new Poll.ContractId(res.contractId).exerciseFinalizePoll(individualParty);
        submit(client, individualParty, finalize);
      }
      else{
        var update = pollCids.get(pollId).exerciseVote(vote);
        submit(client, individualParty, update);
        System.out.printf("Vote submitted sucessfully.\n");
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
