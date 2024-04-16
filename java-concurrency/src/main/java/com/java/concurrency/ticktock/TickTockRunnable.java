package com.java.concurrency.ticktock;

public class TickTockRunnable implements Runnable{
    private String word;
    private int delay;

    public TickTockRunnable(String word, int delay){
        this.word = word;
        this.delay = delay;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                System.out.print(word + " ");
                Thread.sleep(delay);
            }catch (InterruptedException ie){
                Thread.currentThread().interrupt();;
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TickTockRunnable("tick", 50));
        Thread t2 = new Thread(new TickTockRunnable("tock", 100));
        t1.start();
        t2.start();
    }
}
