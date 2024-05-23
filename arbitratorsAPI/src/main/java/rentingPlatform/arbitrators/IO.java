package rentingPlatform.arbitrators;


import java.util.Scanner;

import java.util.concurrent.ConcurrentHashMap;
import com.google.common.collect.BiMap;

import rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators;

import static rentingPlatform.arbitrators.Arbitrator.debug;

public class IO {

  Scanner sc = new Scanner(System.in);

  public IO(){
  }

  public void displayMenu() {
    System.out.printf("1. Search MI\n");
    System.out.printf("2. Create Votation\n");
    System.out.printf("3. Submit Vote\n");
    System.out.printf("------\n\n");
  }


  private void displayMIdetails(long id, InviteArbitrators invitation) {
    System.out.printf("ID: %d\n", id);
    System.out.printf("   Location: %s\n", invitation.miDetails.house.address.toString());
    System.out.printf("   Description: %s\n", invitation.miDetails.description.toString());
    System.out.printf("   Starting Date: %s\n", invitation.miDetails.startingDate.toString());
    System.out.printf("   Number of arbitrators to be assigned: %s\n", invitation.miDetails.nArbitrators.toString());
    System.out.printf("------\n\n");
  }


  public long invitationChoice(ConcurrentHashMap<Long, InviteArbitrators> invitations, BiMap<Long, InviteArbitrators.ContractId>  invitationsCids) {
   
    invitations.forEach((id, invitation) -> {  
      displayMIdetails(id, invitation); 
    });

    System.out.printf("> Select ID: "); 
    long id = sc.nextLong();
    System.out.printf("> Selected: %s\n", invitationsCids.get(id).toString());
    return id;
  }

}
