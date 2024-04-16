package com.java.concurrency.scheduled.execution;

import java.util.Date;
import java.util.concurrent.*;

public class ScheduledThreadPool {
    /*
    * we schedule a task that prints out the current date/time value as a String, to run every second,
    * after an initial 1 second delay. We then schedule another task to cancel this first task and shut down the Executor.
    * This task runs once only, after 10 seconds.
    * */
    public static void main(String[] args) {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable ticker = () -> System.out.println(new Date().toString());

        final ScheduledFuture<?> tickerHandler = scheduler.scheduleAtFixedRate(ticker, 1,1, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            tickerHandler.cancel(true);
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
    }
}
