package com.sk.thread1;

public class MultiThreading implements Runnable{
    @Override
    public void run() {
        System.out.println("new Thread  "+ Thread.currentThread().getName());

    }

    public static void main(String[] args) {
       System.out.println("Started main thread"+Thread.currentThread().getName());
        MultiThreading obj=new MultiThreading();
        Thread t=new Thread(obj);//thread has created at this point of time thread is not started

        t.start(); //thread is started
      //  t.run();

        System.out.println("Finish main thread"+Thread.currentThread().getName());
    }

}
