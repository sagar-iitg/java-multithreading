package com.sk.thread;

public class Example16 {


    public static int counter=0;



    // we have to make sure this method is executed only by a single thread.
    // at a given time.


    private static void increment()
    {
        synchronized (Example16.class)
        {
            counter++;
        }
       // counter++;

    }
    private static void process() throws InterruptedException {

        int size=20000000;

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<size;i++){
                    // System.out.println(Thread.currentThread().getName());
                    increment();
                }


            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<size;i++)
                {
                    //   System.out.println(Thread.currentThread().getName());
                    increment();
                }

            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("The counter is: "+counter);
        System.out.println("Process method");

    }
    public static void main(String[] args) throws InterruptedException {


        process();

    }
}
