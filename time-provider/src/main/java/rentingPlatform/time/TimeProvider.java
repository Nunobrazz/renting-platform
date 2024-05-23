package rentingPlatform.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimeProvider {
  
  private static final Logger logger = LoggerFactory.getLogger(TimeProvider.class);
  

  
  public static void main(String[] args) {

    // Extract host and port from arguments
    if (args.length < 3) {
      System.err.println("Usage: LEDGER_HOST LEDGER_PORT PARTY");
      System.exit(-1);
    }
    String ledgerhost = args[0];
    int ledgerApiPort = Integer.valueOf(args[1]);
    String party = args[2];
    
    debug("Runing as party: {}", party);
    
    LedgerCommunication ledger = new LedgerCommunication(ledgerhost, ledgerApiPort, party);
    
  

    ledger.activateEvolveContractProbing();
    ledger.activateClockUpdatEvents();

    ledger.getCurrentState();




    while (true) {
      try {
        debug("\n\nPress enter to advance one day." ,"");
        System.in.read(); 
        ledger.advanceClock(1);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } 
  }

  public static void debug(String s1 , Object  s2) {
    logger.info(s1,s2);
  }

}