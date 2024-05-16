package rentingPlatform;

import java.util.*;
import static java.util.UUID.randomUUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import org.slf4j.Logger;
import com.daml.ledger.javaapi.data.*;
import com.daml.ledger.javaapi.data.CommandsSubmission;
import com.daml.ledger.javaapi.data.codegen.Update;
import com.daml.ledger.rxjava.DamlLedgerClient;
import com.daml.ledger.rxjava.LedgerClient;
import org.slf4j.LoggerFactory;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import rentingPlatform.codegen.time.clock.DateClock;
import rentingPlatform.LedgerCommunication;


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

    debug("First thread id:" + Thread.currentThread().getId(), "");
    

    debug("LEDGER COMMUNICATION", "");
    LedgerCommunication ledger = new LedgerCommunication(ledgerhost, ledgerApiPort, party);
    
    
    debug("Active Threads: {}", Thread.activeCount());
    

    ledger.getCurrentActiveContracts();

    debug("Active Threads: {}", Thread.activeCount());


    ledger.activateEvolveContractProbing();

    debug("Active Threads: {}", Thread.activeCount());


    while (true) {
      try {
        debug("\n\nSleeping 7 secs..." ,"");
        Thread.sleep( 7000);
        ledger.advanceClock(1);
        debug("Active Threads: {}", Thread.activeCount());

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }




    /*/ Schedule advance days
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    Runnable task = () -> ledger.advanceClock(1);

    try{
      var result = scheduler.scheduleAtFixedRate(task, 0, 24, TimeUnit.HOURS).get();
    }catch (Exception e) {
      e.printStackTrace();
    }
    */


  }

  public static void debug(String s1 , Object  s2) {
    logger.info(s1,s2);
  }

}