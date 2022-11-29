package com.sk.thread;

public class Example14 {


    public static int counter1=0;
    public static int counter2=0;
    private static  final Object lock1=new Object();
    private static  final Object lock2=new Object();




    // we have to make sure this method is executed only by a single thread.
    // at a given time.



    private static  synchronized void increment1 ()

    {



        synchronized (lock1)
        {
            counter1++;

        }

    }
    private static  synchronized void increment2 ()

    {
        synchronized (lock2)
        {
            counter2++;
        }

    }
    private static void process() throws InterruptedException {

        int size=200000;

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<size;i++){
                    // System.out.println(Thread.currentThread().getName());
                    increment1();
                }


            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<size;i++)
                {
                    //   System.out.println(Thread.currentThread().getName());
                    increment2();
                }

            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("The counter is: "+counter1);
        System.out.println("The counter is: "+counter2);
        System.out.println("completed Process method");

    }
    public static void main(String[] args) throws InterruptedException {


        process();

    }
}
