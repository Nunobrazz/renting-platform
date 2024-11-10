package rentingPlatform.user;

import java.util.*;
import java.time.LocalDate;

import static java.util.UUID.randomUUID;

import java.rmi.dgc.Lease;
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
import rentingPlatform.codegen.platform.modelmi.AvailableArbitrators;
import rentingPlatform.codegen.platform.modelmi.AvailableArbitratorsRequest;
import rentingPlatform.codegen.platform.modella.LeaseAgreement;
import rentingPlatform.codegen.time.lifecycle.iou.Iou;


public class LedgerCommunication {
    public static final String APP_ID = "RentingPlatform";

    public String individualParty;
    public String publicParty;

    public DamlLedgerClient client;
    
    public static final AtomicReference<LedgerOffset> acsOffset = new AtomicReference<>(LedgerOffset.LedgerBegin.getInstance()); 
    public AtomicLong lasIdCounter = new AtomicLong(0); 
    public AtomicLong miReportsIdCounter = new AtomicLong(0); 

    ConcurrentHashMap<Long, LeaseAgreement> las = new ConcurrentHashMap<>();
    BiMap<Long, LeaseAgreement.ContractId> lasCids = Maps.synchronizedBiMap(HashBiMap.create());
    
    ConcurrentHashMap<Long, MIReport> miReports = new ConcurrentHashMap<>();
    BiMap<Long, MIReport.ContractId> miReportCids = Maps.synchronizedBiMap(HashBiMap.create());
    
    // Inutil pq so faz probe para quando estiver cheio
    //ConcurrentHashMap<Long, InviteArbitrators> inviteArbitrators = new ConcurrentHashMap<>(); 
    //BiMap<Long, InviteArbitrators.ContractId> inviteArbitratorsCids = Maps.synchronizedBiMap(HashBiMap.create());
    
    AvailableArbitrators.Contract availableArbitrators;
    
    public IO io;

    // creates 6 threads
    LedgerCommunication(String ledgerhost, int ledgerApiPort, String individualParty, String publicParty) {
  
      this.individualParty = individualParty;
      this.publicParty = publicParty;

      client = DamlLedgerClient.newBuilder(ledgerhost, ledgerApiPort).build();  
      // Connects to the ledger and runs initial validation.
      client.connect();
      System.out.printf("Connceted to: %s\n", client.getLedgerId());

      io = new IO();

      getLAsCurrentState();
      getMIReportsCurrentState();
      probeLAs();
      probeMIReports();
      getAvailableArbitratorsCurrentState();
      getInviteArbitratorsCurrentState();
      probeInviteArbitrators();
      probeIOU();
      probeAvailableArbitrators();

    }

    public ConcurrentHashMap<Long, MIReport> getMIs(){
      return miReports;
    }
    public ConcurrentHashMap<Long, LeaseAgreement> getLAs(){
      return las;
    }
    public AvailableArbitrators.Contract getAvailableArbitrators(){
      return availableArbitrators;
    }
    private void setAtomicId(){
      //todo
    }

    private void getLAsCurrentState(){
      client
      .getActiveContractSetClient()
      .getActiveContracts(LeaseAgreement.contractFilter(), Collections.singleton(individualParty), true)
      .blockingForEach(
          response -> {
            response.offset.ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
            response.activeContracts.forEach(
                contract -> {
                  long id = lasIdCounter.getAndIncrement();
                  las.put(id, contract.data);
                  lasCids.put(id, contract.id);
                  System.out.printf("You have a stake in a LA.\n");
                });
          });
    }
    private void getMIReportsCurrentState(){
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
    private void getInviteArbitratorsCurrentState(){
      client
      .getActiveContractSetClient()
      .getActiveContracts(InviteArbitrators.contractFilter(), Collections.singleton(individualParty), true)
      .blockingForEach(
        response -> {
          response.offset.ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
          response.activeContracts.forEach(
              contract -> {
                if (contract.data.confirmed.map.size() == contract.data.miDetails.nArbitrators){
                  var confirmAttributionUpdate = contract.id.exerciseConfirmAttribution(individualParty);
                  submit(client, individualParty, confirmAttributionUpdate);
                  System.out.println("Invitation Finalized.");
                }
              });
        });
    }
    private void getAvailableArbitratorsCurrentState(){
      client
      .getActiveContractSetClient()
      .getActiveContracts(AvailableArbitrators.contractFilter(), Collections.singleton(publicParty), true)
      .blockingForEach(
          response -> {
            response.offset.ifPresent(offset -> acsOffset.set(new LedgerOffset.Absolute(offset)));
            response.activeContracts.forEach(
                contract -> {
                  this.availableArbitrators = contract;
                });
          });
    }
    private void probeLAs(){
      client
            .getTransactionsClient()
            .getTransactions(  
                LeaseAgreement.contractFilter(), acsOffset.get(), Collections.singleton(individualParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    long id = miReportsIdCounter.getAndIncrement();
                    LeaseAgreement.Contract contract = LeaseAgreement.Contract.fromCreatedEvent(createdEvent);
                    las.put(id, contract.data);
                    lasCids.put(id, contract.id);
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event; 
                    LeaseAgreement.ContractId archivedCid = new LeaseAgreement.ContractId(archivedEvent.getContractId());
                    long id = lasCids.inverse().get(archivedCid); 
                    miReports.remove(id);
                    lasCids.remove(id);
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
                    long id = miReportsIdCounter.getAndIncrement();
                    MIReport.Contract contract = MIReport.Contract.fromCreatedEvent(createdEvent);
                    miReports.put(id, contract.data);
                    miReportCids.put(id, contract.id);
                    //System.out.printf("Created MI id: %d\n", id);
                  } else if (event instanceof ArchivedEvent) {
                    ArchivedEvent archivedEvent = (ArchivedEvent) event; 
                    MIReport.ContractId archivedCid = new MIReport.ContractId(archivedEvent.getContractId());
                    long id = miReportCids.inverse().get(archivedCid); 
                    miReports.remove(id);
                    miReportCids.remove(id);
                  }
                }
              });
    }

    private void probeIOU(){
      client
            .getTransactionsClient()
            .getTransactions(
              Iou.contractFilter(), acsOffset.get(), Collections.singleton(individualParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    Iou.Contract contract = Iou.Contract.fromCreatedEvent(createdEvent);
                    io.displayIouDetails(contract.data);
                  } else if (event instanceof ArchivedEvent) {
                    System.out.printf("IOU TERMINATED.\n");                    
                  }
                }
                });
    }

    private void probeInviteArbitrators(){ 
        client
        .getTransactionsClient()
        .getTransactions(  
          InviteArbitrators.contractFilter(), acsOffset.get(), Collections.singleton(individualParty), true)
        .subscribe(
          transaction -> {
              for (Event event : transaction.getEvents()) {
                  if (event instanceof CreatedEvent) {
                      CreatedEvent createdEvent = (CreatedEvent) event;
                      InviteArbitrators.Contract contract = InviteArbitrators.Contract.fromCreatedEvent(createdEvent);
  
                      if (contract.data.confirmed.map.size() == contract.data.miDetails.nArbitrators) {
                          var confirmAttributionUpdate = contract.id.exerciseConfirmAttribution(individualParty);
                          submit(client, individualParty, confirmAttributionUpdate);
                          System.out.println("Invitation Finalized.");
                      }
                  }
              }
          },
          throwable -> {
              // Handle any errors during subscription
              //System.err.println("Error processing transaction:");
          });
        
    
    }
    
    private void probeAvailableArbitrators(){ // public party
      client
            .getTransactionsClient()
            .getTransactions(
                AvailableArbitrators.contractFilter(), acsOffset.get(), Collections.singleton(publicParty), true)
            .forEach(
              t -> {
                for (Event event : t.getEvents()) {
                  if (event instanceof CreatedEvent) {
                    CreatedEvent createdEvent = (CreatedEvent) event;
                    this.availableArbitrators = AvailableArbitrators.Contract.fromCreatedEvent(createdEvent);
                    System.out.printf("Update in available arbitrators.\n");                    
                  }  }
                }); 
    }

    public void invokeArbitrators(long laId, long miReportId){
      if (miReports.get(miReportId).activeInvitation){
        System.out.println("There is an Active Invitation Process.");
        return;
      }
      // create AvailableArbitratorsRequest 
      var aaCreate = AvailableArbitratorsRequest.create(publicParty, individualParty);
      var aaReqContractId = submit(client, individualParty, aaCreate).contractId;
      // AvailableArbitrators add observer with public 
      var addObserverUpdate = availableArbitrators.id.exerciseAddObserver(aaReqContractId, publicParty);
      var privAvailableArbitratorsCid = submit(client, publicParty, addObserverUpdate).exerciseResult;
      // Invoke Arbitrators with laId 
      var invokeArbitratorsUpdate = lasCids.get(laId).exerciseInvokeArbitrators(individualParty, privAvailableArbitratorsCid, miReportCids.get(miReportId));      
      submit(client, individualParty, invokeArbitratorsUpdate);
      System.out.println("\nArbitrators have been Invited.");
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
