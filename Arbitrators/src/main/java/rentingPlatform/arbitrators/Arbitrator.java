package rentingPlatform.arbitrators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import com.google.common.collect.BiMap;

import rentingPlatform.codegen.platform.leaseagreement.modelmi.InviteArbitrators;

import java.util.Scanner;

public class Arbitrator {
  
  private static final Logger logger = LoggerFactory.getLogger(Arbitrator.class);
  
  static Scanner sc = new Scanner(System.in);

  static IO io = new IO();

  private static LedgerCommunication ledger;

  
  public static void main(String[] args) throws InterruptedException {

    // Extract host and port from arguments
    if (args.length < 3) { //it will need the party arbitroator
      System.err.println("Usage: LEDGER_HOST LEDGER_PORT INDIVIDUAL_PARTY.");
      System.exit(-1);
    }
    
    String ledgerhost = args[0];
    int ledgerApiPort = Integer.valueOf(args[1]);
    String individualParty = args[2];

    debug("Runing as party: {}", individualParty );

    ledger = new LedgerCommunication(ledgerhost, ledgerApiPort, individualParty);
    

    ledger.getInvitationsCurrentState();    
    ledger.probeInvitations();
    ledger.probeMIReports();
    ledger.probeVotations();
    
    while (true) {
      io.displayMenu();
      System.out.printf("> Select Option: "); 
      long option = sc.nextInt();
      if (option == 1){
        ledger.searchInvitations();
      }
      else if (option == 2){
        ledger.createVotation();
      }
      else if (option == 3){
        ledger.submitVote();
      }
      else{
        System.out.println("Invalid Option");
      }
      Thread.sleep(1000);
    }
  }

  public static void debug(String s1 , Object  s2) {
    logger.info(s1,s2);
  }

}