package com.sk.thread;


class Process
{


    public void produce() throws InterruptedException
    {


        synchronized (this)
        {
            System.out.println("Running the produce method");
            wait();
            System.out.println("Again in the Producer Method");
        }
    }


    public void consume() throws InterruptedException
    {


        synchronized (this)
        {
            System.out.println("Consume method is executed");
            notify();

        }
    }
}
public class Example15 {


    public static void main(String[] args) {

        Process p=new Process();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

    }
}
