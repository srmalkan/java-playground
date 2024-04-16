package com.java.concurrency.returning.value;

import java.util.Random;

public class NumberService {
    public static Random random = new Random();
    public static int getNumberAndPrint(){
        delay();
        int theNum = random.nextInt() % 100;
//        System.out.println("Thread; " + Thread.currentThread().getId()+ " returning: "+theNum);
        return theNum;
    }

    private static void delay(){
        try{
            long val = Math.abs(random.nextInt() % 2) + 1;
//            System.out.println(val);
            Thread.sleep((val) * 1000);
        }catch (InterruptedException ignore){

        }
    }
}
