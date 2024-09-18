package rentingPlatform.user;

import java.util.InputMismatchException;

public class User {
  
  
  static IO io = new IO();

  private static LedgerCommunication ledger;

  
  public static void main(String[] args) throws InterruptedException {

    // Extract host and port from arguments
    if (args.length < 4) { //it will need the party arbitroator
      System.err.println("Usage: LEDGER_HOST LEDGER_PORT INDIVIDUAL_PARTY PUBLIC_PARTY.");
      System.exit(-1);
    }
    
    String ledgerhost = args[0];
    int ledgerApiPort = Integer.valueOf(args[1]);
    String individualParty = args[2];
    String publicParty = args[3];

    try{
      ledger = new LedgerCommunication(ledgerhost, ledgerApiPort, individualParty, publicParty);
      io.displayMainMenu(ledger);
    }catch(InputMismatchException e){
      System.err.println("Error parsing input going back to Main Menu");
      io.displayMainMenu(ledger);
    }
  }

}