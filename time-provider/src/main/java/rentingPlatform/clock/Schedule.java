package rentingPlatform.clock;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Schedule {
  public static void main(String[] args) {
      // Create a ScheduledExecutorService
      ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

      // Define the task to be executed
      Runnable task = () -> System.out.println("Hello, world!");

      // Schedule the task to run every day at 8:00 AM

      scheduler.scheduleAtFixedRate(task, 0, 24, TimeUnit.HOURS);

      // Keep the application running
      try {
          Thread.sleep(10000); // Sleep for 10 seconds to see the output
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}
