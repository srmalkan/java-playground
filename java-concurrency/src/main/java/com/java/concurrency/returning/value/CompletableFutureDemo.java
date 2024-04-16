package com.java.concurrency.returning.value;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureDemo {
    public static Future<Integer> fetchIntCF(){
//        CompletableFuture<Integer> numF = new CompletableFuture<>();
//
//        new Thread(() -> {
//            int num = NumberService.getNumberAndPrint();
//            numF.complete(num);
//        }).start();
//
//        return numF;
        return CompletableFuture.supplyAsync(() -> NumberService.getNumberAndPrint());
    }

    public static void main(String[] args) {
        Future<Integer> numF = fetchIntCF();

        int theNum = 0;
        try{
            while(!numF.isDone()){
                System.out.print("Doing something else ");
                Thread.sleep(500);
            }
            theNum = numF.get();
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        }catch (CancellationException e){

        }
        System.out.println("Returned Number: "+ theNum);
    }
}
