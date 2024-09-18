package rentingPlatform.user;


import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import rentingPlatform.codegen.platform.modelmi.AvailableArbitrators;
//import rentingPlatform.codegen.platform.modelmi.InviteArbitrators;
import rentingPlatform.codegen.platform.modelmi.MIReport;
import rentingPlatform.codegen.platform.modella.LeaseAgreement;
import rentingPlatform.codegen.platform.types.mi.MIdetails;
import rentingPlatform.codegen.time.lifecycle.iou.Iou;

public class IO {

  Scanner sc = new Scanner(System.in);

  public IO(){
  }

  private void displayMIdetails(long id, MIReport miReport) { // Cannot see during poll
    System.out.printf("ID: %d\n", id);
    System.out.printf("   Location: %s\n", miReport.miDetails.house.address.toString());
    System.out.printf("   Description: %s\n", miReport.miDetails.description.toString());
    System.out.printf("   Starting Date: %s\n", miReport.miDetails.startingDate.toString());
    System.out.printf("   Number of arbitrators agreed: %s\n", miReport.miDetails.nArbitrators.toString());
    if (miReport.arbitrators.map.isEmpty()){
      System.out.printf("   No Arbitrators Assigned.\n");
    }
    else{
      System.out.printf("   Arbitrators Assigned:\n");
      miReport.arbitrators.map.forEach((arbitrator, k) ->{
        System.out.println("      " + arbitrator.toString());
      });
    }
  }
  private void displayLAdetails(long serviceId, LeaseAgreement service) {
    System.out.printf("ID: %d\n", serviceId);
    System.out.printf("   Tenant: %s\n", service.laKey.tenant.toString() );
    System.out.printf("   Host: %s\n", service.laKey.house.host.toString() );
    System.out.printf("   Address: %s\n", service.laKey.house.address.toString() );
  }
  public void displayIouDetails(Iou iou) {
    System.out.println("\n----------- NEW IOU CREATED ---------------------");
    System.out.printf("   Amount: %s\n", iou.amount.toString());
    System.out.printf("   Ower: %s\n", iou.owner.toString());
    System.out.printf("   Debtor: %s\n", iou.debtor.toString());
    System.out.printf("   Payment Date: %s\n", iou.paymentDate.toString());
  }
  public void displayMainMenu(LedgerCommunication ledger) throws InterruptedException {
    
    while (true) {
      System.out.printf("\n\nMAIN MENU\n");
      System.out.printf("1. Make Proposal.\n");
      System.out.printf("2. My Proposals.\n");
      System.out.printf("3. My Lease Agreements.\n");
      System.out.printf("4. Display All Stored Contracts.\n");
      System.out.printf("> Select Option: "); 
      int option = sc.nextInt();
      switch (option) {
        case 1:
          notAvailable();
          break;
        case 2:
          notAvailable();
          break;
        case 3:
          while (true){ 
            ConcurrentHashMap<Long, LeaseAgreement> services = ledger.getLAs();
            if (services.isEmpty()){
              System.out.println("\nNo available Lease Agreements.\n");
              break;
            }
            else{
              services.forEach((serviceId, service) -> {  
                displayLAdetails(serviceId, service); 
              });
              System.out.printf("> Select Service ID: "); 
              long serviceId = sc.nextLong();
              if (services.containsKey(serviceId)){
                displayLAMenu(ledger, serviceId);
                break;
              }
              else
                System.out.println("\nInvalid Service ID.\n");
            }
          }
          break;
        case 4:
          displayAllStoredContracts(ledger);
          break;
        default:
          System.out.println("\nInvalid Option.\n");
          break;
      }
    }
  }

  public void displayLAMenu(LedgerCommunication ledger, long serviceId) throws InterruptedException {
    while (true) {
      System.out.printf("\n\nMY LEASE AGREEMENTS\n");
      System.out.printf("1. Create Maintenance Issue.\n");
      System.out.printf("2. Current Maintenance Issues.\n");
      System.out.printf("3. Other Options.\n");
      System.out.printf("4. Back to Main Menu.\n");
      System.out.printf("> Select Option: "); 
      int option = sc.nextInt();

      switch (option) {
        case 1:
            notAvailable();
            break;
        case 2:
            while (true){
              ConcurrentHashMap<Long, MIReport> mis = ledger.getMIs();
              if (mis.isEmpty()){
                System.out.println("\nNo available MI Reports.\n");
                break;
              }
              else{
                mis.forEach((miReportId, miReport) -> {  
                  displayMIdetails(miReportId, miReport); 
                });
                System.out.printf("> Select MIReport ID: "); 
                long miReportId = sc.nextLong();
              if (mis.containsKey(miReportId)){
                displayCurrentMIMenu(ledger, serviceId, miReportId);
                break;
              }
              else
                System.out.println("\nInvalid MIReport ID.");
            }
          }    
          break;
        case 3:
            notAvailable();
            break;
        case 4:
            return; 
        default:
            System.out.println("Invalid Option.\n");
            break;
      }      
    }
  }

  
  public void displayCurrentMIMenu(LedgerCommunication ledger, long serviceId, long miReportId) throws InterruptedException {
    while (true) {
      System.out.printf("\nMI: %d\n", miReportId);
      System.out.printf("1. Submit Assessment Proposals.\n");
      System.out.printf("2. Assessment Proposals.\n");
      System.out.printf("3. Invoke Arbitrators.\n");
      System.out.printf("4. Back to My Lease Agreements.\n");
      System.out.printf("> Select Option: "); 
      int option = sc.nextInt();
      switch (option) {
        case 1:
            notAvailable();
            break;
        case 2:
            notAvailable();
            break;
        case 3:
          ledger.invokeArbitrators(serviceId, miReportId);      
          return;
        case 4:
            return; 
        default:
            System.out.println("Invalid Option.\n");
            break;
          }      
      }
    }


    public void displayAllStoredContracts(LedgerCommunication ledger){
      System.out.println("\n----------- LEASE AGREEMENTS ---------------------");
      ConcurrentHashMap<Long, LeaseAgreement> services = ledger.getLAs();
      if (services.isEmpty())
        System.out.println("No LA services.");
      else{
        services.forEach((serviceId, service) -> {  
          displayLAdetails(serviceId, service); 
        });
      }
      
      System.out.println("\n----------- MI REPORTS ---------------------");
      ConcurrentHashMap<Long, MIReport> mis = ledger.getMIs();
      if(mis.isEmpty())
        System.out.println("No MI Reports.");
      else{
        mis.forEach((miReportId, miReport) -> {  
          displayMIdetails(miReportId, miReport); 
        });
      }
      
      /*System.out.println("\n----------- INVITE ARBITRATORS ---------------------");
      ConcurrentHashMap<Long, InviteArbitrators> invites = ledger.getInviteArbitrators();
      if (invites.isEmpty())
        System.out.println("No Arbitrators Invitation Contracts.");
      else{
        invites.forEach((inviteId, invite) -> {  
          System.out.printf("Invite: %d\n", inviteId);
          if (invite.confirmed.map.isEmpty())
            System.out.println("No confirmed arbitrators.");
          else{
            System.out.println("Confirmed: ");
            invite.confirmed.map.forEach((arbitrator, k) ->{
              System.out.println("   " + arbitrator.toString());
            });
          }
        });
      }*///
      System.out.println("\n----------- AVAILABLE ARBITRATORS IN THE PLATFORM ---------------------");
      AvailableArbitrators.Contract availableArbitrators = ledger.getAvailableArbitrators();
      if (availableArbitrators == null)
        System.out.println("No Available Arbitrators Contract.");
      else{
        System.out.println("Available Arbitrators: ");
        availableArbitrators.data.arbitrators.map.forEach((arbitrator, k) ->{
          System.out.println("   " + arbitrator.toString());
        });
        }
    }

  public void notAvailable(){
    System.out.printf("\nNot Available.\n");
  }
}
