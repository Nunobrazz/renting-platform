package rentingPlatform.time;




public class TimeProvider {
  

  
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
    

    try{
      LedgerCommunication ledger = new LedgerCommunication(ledgerhost, ledgerApiPort, timeProviderParty, lifecyclerParty);

      while (true) {
        System.in.read(); 
        //long start = System.nanoTime();
        ledger.advanceClock();
        //double latency = (double) (System.nanoTime() - start)/1_000_000_000;
        //System.out.println("\n\n\n\nlatency: " + latency);
      } 

      }catch (Exception e){
        e.printStackTrace();
      } 

  }


}