package rentingPlatform.arbitrators;


import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

import java.util.concurrent.ConcurrentHashMap;
import com.google.common.collect.BiMap;

import rentingPlatform.codegen.platform.types.mi.AssessmentDetails;
import rentingPlatform.codegen.platform.types.mi.MIdetails;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.MIReport;
import rentingPlatform.codegen.platform.types.mi.Responsability;

import static rentingPlatform.arbitrators.Arbitrator.debug;

public class IO {

  Scanner sc = new Scanner(System.in);

  public IO(){
  }

  public void displayMenu() {
    System.out.printf("1. Enroll in unassigned MIs\n");
    System.out.printf("2. Create Votation\n");
    System.out.printf("3. Submit Vote\n");
    System.out.printf("------\n\n");
  }


  private void displayMIdetails(long id, MIdetails miDetails) {
    System.out.printf("ID: %d\n", id);
    System.out.printf("   Location: %s\n", miDetails.house.address.toString());
    System.out.printf("   Description: %s\n", miDetails.description.toString());
    System.out.printf("   Starting Date: %s\n", miDetails.startingDate.toString());
    System.out.printf("   Number of arbitrators to be assigned: %s\n", miDetails.nArbitrators.toString());
    System.out.printf("------\n\n");
  }




  public String askVisitDetails() {
    System.out.printf("Please insert the visit details.\n");
    String visitDetails = sc.nextLine();

    return visitDetails;
  }


  public AssessmentDetails askAssessmentDetails() {

    System.out.printf("Tenant's Responsability: ");
    Long tenantResp = sc.nextLong();
    System.out.printf("Hosts's Responsability: ");
    Long hostResp = sc.nextLong();
    Responsability responsability = new Responsability(tenantResp, hostResp);

    System.out.printf("Reparation Cost: ");
    long cost = sc.nextLong();

    System.out.printf("Date of assessment: ");    
    String dateString = sc.next();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate assessmentDate = LocalDate.parse(dateString, formatter);

    System.out.printf("Date of reparation: ");
    dateString = sc.next();
    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate reparationDate = LocalDate.parse(dateString, formatter);

    AssessmentDetails assessmentDetails = new AssessmentDetails(responsability, cost, assessmentDate, reparationDate);

    return assessmentDetails;
  }


  public Responsability askVote() {

    System.out.printf("Tenant's Responsability: ");
    Long tenantResp = sc.nextLong();
    System.out.printf("Hosts's Responsability: ");
    Long hostResp = sc.nextLong();
    Responsability responsability = new Responsability(tenantResp, hostResp);

    return responsability;
  }



  public long invitationChoice(ConcurrentHashMap<Long, InviteArbitrators> invitations, BiMap<Long, InviteArbitrators.ContractId>  invitationsCids) {
   
    invitations.forEach((id, invitation) -> {  
      displayMIdetails(id, invitation.miDetails); 
    });

    System.out.printf("> Select MI Invitation ID: "); 
    long id = sc.nextLong();
    System.out.printf("> Selected: %s\n", invitationsCids.get(id).toString());

    return id;
  }

  public long miChoice(ConcurrentHashMap<Long, MIReport> miReps, BiMap<Long, MIReport.ContractId>  miRepCids) {
   
    miReps.forEach((id, miReport) -> {  
      displayMIdetails(id, miReport.miDetails); 
    });

    System.out.printf("> Select MI Report ID: "); 
    long id = sc.nextLong();
    System.out.printf("> Selected: %s\n", miRepCids.get(id).toString());

    return id;
  }


}
