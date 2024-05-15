package rentingPlatform.clock;

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



public class Clock {
}