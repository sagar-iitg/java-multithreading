package com.sk.reentrant;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> q=new ArrayBlockingQueue<>(2,true);

        //Producer Thread
        new Thread(()->{
            try{
                for(int i=0;i<=100;i++){
                    System.out.println("Producing: " + i);
                    q.put(i); // waits if full
                    Thread.sleep(500);
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }


        }).start();

        //consumer Thread
        new Thread(()->{
            try {
                while (true) {
                    Integer item = q.take(); // waits if empty
                    System.out.println("Consumed: " + item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }).start();

    }
}
