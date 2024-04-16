package com.java.concurrency.returning.value;

import java.util.concurrent.*;

public class CallableAndFutureDemo {
    public static void main(String[] args) {
        Callable<Integer> fetchNum = () -> NumberService.getNumberAndPrint();

        System.out.println("Main thread id: "+ Thread.currentThread().getId());

        //ExecutorService : An Executor that provides methods to manage termination
        // and methods that can produce a Future for tracking progress of one or more asynchronous tasks.
        ExecutorService engine = Executors.newFixedThreadPool(2);
        Future<Integer> numF = engine.submit(fetchNum);

        int theNum = 0;
        try{
            while(!numF.isDone()){
                System.out.print(".");
                Thread.sleep(200);
            }
            theNum = numF.get();
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        }catch (CancellationException e){

        }
        System.out.println("Returned Number: "+ theNum);
    }
}
