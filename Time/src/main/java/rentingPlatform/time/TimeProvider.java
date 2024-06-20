package rentingPlatform.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimeProvider {
  
  private static final Logger logger = LoggerFactory.getLogger(TimeProvider.class);
  

  
  public static void main(String[] args) {

    // Extract host and port from arguments
    if (args.length < 4) {
      System.err.println("Usage: LEDGER_HOST LEDGER_PORT TIME_PROVIDER_PARTY LIFECYCLER_PARTY.");
      System.exit(-1);
    }
    String ledgerhost = args[0];
    int ledgerApiPort = Integer.valueOf(args[1]);
    String timeProviderParty = args[2];
    String lifecyclerParty = args[3];
    
    debug("Runing as party: {}", timeProviderParty);
    debug("Runing as party: {}", lifecyclerParty);
    
    LedgerCommunication ledger = new LedgerCommunication(ledgerhost, ledgerApiPort, timeProviderParty, lifecyclerParty);
    


    ledger.getCurrentState();

    ledger.probeDateClocks();
    ledger.probeEvolve();





    while (true) {
      try {
        System.out.printf("\n\nPress enter to advance one day.");
        System.in.read(); 
        ledger.advanceClock();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } 
  }

  public static void debug(String s1 , Object  s2) {
    logger.info(s1,s2);
  }

}