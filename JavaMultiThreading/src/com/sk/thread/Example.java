package com.sk.thread;

public class Example {


    public static void main(String[] args) throws InterruptedException {

        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                //code that will run in new thread
                System.out.println("We are now in thread "+Thread.currentThread().getName());
                System.out.println("Current thread priority is   "+ Thread.currentThread().getPriority());

            }
        });
        t.setName("New Worker Method");

        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println(" we are in thread----       "+t.currentThread().getName()+"         before starting a new thread");
        t.start();
        System.out.println("we are in currentthread----      "+t.currentThread().getName()+"          after starting a new thread");

        Thread.sleep(1000);



    }
}
