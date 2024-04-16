package com.java.concurrency.numberService;

import java.util.Random;

public class NumberService {
    public static Random random = new Random();
    public static void getNumberAndPrint(){
        int theNum = random.nextInt() % 100;
        delay();
        System.out.println("Thread; " + Thread.currentThread().getId()+ " returning: "+theNum);
    }

    private static void delay(){
        try{
            Thread.sleep((long)(Math.abs(random.nextInt()%2)+1)*1000);
        }catch (InterruptedException ignore){

        }
    }
}
