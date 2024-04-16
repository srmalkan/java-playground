package com.java.concurrency.numberService;

import java.util.concurrent.Executor;

public class InThreadExecutor {
    /*
    Main thread id: 1
    Thread; 1 returning: 43
    Thread; 1 returning: 66
    Thread; 1 returning: 68
    *  */
    public static void main(String[] args) {
        Runnable work = () -> {NumberService.getNumberAndPrint();};

        System.out.println("Main thread id: "+ Thread.currentThread().getId());

        Executor threadPerTask = t -> t.run();

        threadPerTask.execute(work);
        threadPerTask.execute(work);
        threadPerTask.execute(work);
    }
}
