package com.java.concurrency.numberService;

import java.util.concurrent.Executor;

public class ThreadPerTaskExecutor {
    /*
        Main thread id: 1
        Thread; 14 returning: 41
        Thread; 15 returning: -29
        Thread; 16 returning: -52
    * */
    public static void main(String[] args) {
        Runnable work = () -> {NumberService.getNumberAndPrint();};

        System.out.println("Main thread id: "+ Thread.currentThread().getId());

        Executor threadPerTask = t -> new Thread(t).start();

        threadPerTask.execute(work);
        threadPerTask.execute(work);
        threadPerTask.execute(work);
    }
}
