package rentingPlatform.arbitrators;


import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

import java.util.concurrent.ConcurrentHashMap;
import com.google.common.collect.BiMap;

import rentingPlatform.codegen.platform.types.mi.MIdetails;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.MIReport;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.Poll;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.CreatePoll;
import rentingPlatform.codegen.platform.leaseagreement.modelmi.Vote;
import rentingPlatform.codegen.platform.types.mi.Responsability;


public class IO {

  Scanner sc = new Scanner(System.in);

  public IO(){
  }

  private void displayMIDetails(MIdetails miDetails) {
    System.out.printf("   Location: %s\n", miDetails.house.address.toString());
    System.out.printf("   Description: %s\n", miDetails.description.toString());
    System.out.printf("   Starting Date: %s\n", miDetails.startingDate.toString());
    System.out.printf("   Number of arbitrators to be assigned: %s\n", miDetails.nArbitrators.toString());
  }
  private void displayMIReport(MIReport miReport) {
    displayMIDetails(miReport.miDetails); 
    if (miReport.arbitrators.map.isEmpty()){
      System.out.printf("No Arbitrators Assigned.");
    }
    else{
      System.out.printf("   Arbitrators Assigned:\n");
      miReport.arbitrators.map.forEach((arbitrator, k) ->{
        System.out.println("      " + arbitrator.toString());
      });
    }
  }
  private void displayPollDetails(Poll poll){
    System.out.printf("MI Details:\n");
    displayMIDetails(poll.miDetails);
    System.out.printf("   Visit Details: %s\n", poll.visitDetails.toString());
    System.out.printf("   Cost: %s\n", poll.cost.toString());
    System.out.printf("   Assessment Date: %s\n", poll.assessmentDate.toString());
    System.out.printf("   Reparation Date: %s\n", poll.reparationDate.toString());
    if (poll.voters.map.isEmpty()){
      System.out.printf("No Votes yet.");
    }
    else{
      System.out.printf("   Votes:\n");
      for (Responsability vote : poll.votes){
        System.out.println("      Tenant Responsability:" + vote.tenantResp.toString());
        System.out.println("      Host Responsability:" + vote.hostResp.toString());
        System.out.printf("-------------\n");
      }
    }
  }
  private CreatePoll askCreatePoll(String individualParty){ // handle parsing exceptions
    System.out.printf("Visit details: ");
    String visitDetails = sc.next();
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
    System.out.printf("Tenant's Responsability: ");
    Long tenantResp = sc.nextLong();
    System.out.printf("Hosts's Responsability: ");
    Long hostResp = sc.nextLong();
    Responsability responsability = new Responsability(tenantResp, hostResp);
    return new CreatePoll(individualParty, visitDetails, responsability, cost, assessmentDate, reparationDate);
  }

  private Vote askVote(String individualParty){
    System.out.printf("Tenant's Responsability: ");
    Long tenantResp = sc.nextLong();
    System.out.printf("Hosts's Responsability: ");
    Long hostResp = sc.nextLong();
    Responsability responsability = new Responsability(tenantResp, hostResp);
    return new Vote(individualParty, responsability);
  }

  public void displayMainMenu(LedgerCommunication ledger) {
    while(true){
      System.out.printf("\n\nMAIN MENU\n");
      System.out.printf("1. List Invitations to MIReports\n");
      System.out.printf("2. List Assigned MIReports.\n"); // Can only execute CreatePoll
      System.out.printf("3. List Polls\n");
      System.out.printf("> Select Option: "); 
      int option = sc.nextInt();
      switch (option) {
        case 1:
          while (true){
            System.out.println("Invitations to MIReports\n");
            ConcurrentHashMap<Long, InviteArbitrators> invitations = ledger.getInvitations();
            if (invitations.isEmpty()){
              System.out.println("No Invitations to MI Reports available.");
              break;
            }
            else{
              invitations.forEach((invitationId, invitation) -> {  
                System.out.printf("ID: %d\n", invitationId);
                displayMIDetails(invitation.miDetails); 
              });
              System.out.printf("> Select Invitation ID: "); 
              long invitationId = sc.nextLong();
              if (invitations.containsKey(invitationId)){
                System.out.printf("Selected:\n"); 
                displayMIDetails(invitations.get(invitationId).miDetails); 
                System.out.printf("   Accept[y/n]"); 
                String answer = sc.next();
                if (answer.equals("n") || answer.equals("N")){}
                else{
                  ledger.acceptInvitation(invitationId);
                }
                break;
              }
            else
              System.out.println("\nInvalid MIReport ID.");
            }
          }
          break;
        case 2:
          while (true){
            System.out.println("Assigned MIReports\n");
            ConcurrentHashMap<Long, MIReport> mis = ledger.getAssignedMIReports();
            if (mis.isEmpty()){
              System.out.println("\nNo Assigned MI Reports.\n");
              break;
            }
            else{
              mis.forEach((miReportId, miReport) -> {  
                System.out.printf("ID: %d\n", miReportId);
                displayMIReport(miReport); 
              });
              System.out.printf("> Choose MIReport ID to Create Poll: "); 
              long miReportId = sc.nextLong();
              if (mis.containsKey(miReportId)){
                System.out.printf("Selected:\n"); 
                displayMIReport(mis.get(miReportId)); 
                CreatePoll createPoll = askCreatePoll(ledger.getIndividualParty());
                ledger.createPoll(createPoll, miReportId);
                break;
              }
            else
              System.out.println("\nInvalid MIReport ID.");
            }
          }
          break;
        case 3:
          while (true){
            System.out.println("Polls\n");
            ConcurrentHashMap<Long, Poll> polls = ledger.getPolls();
            if (polls.isEmpty()){
              System.out.println("No Current Polls.\n");
              break;
            }
            else{
              polls.forEach((pollId, poll) -> {  
                System.out.printf("ID: %d\n", pollId);
                displayPollDetails(poll); 
              });
              System.out.printf("> Select Poll ID: "); 
              long pollId = sc.nextLong();
              if (polls.containsKey(pollId)){
                System.out.printf("Selected:\n"); 
                displayPollDetails(polls.get(pollId)); 
                Vote vote = askVote(ledger.getIndividualParty());
                ledger.submitVote(vote, pollId);
                break;
              }
            else
              System.out.println("\nInvalid MIReport ID.");
            }
          }
          break;
        default:
          System.out.println("\nInvalid Option.\n");
          break;
      }
    }
  }



}
