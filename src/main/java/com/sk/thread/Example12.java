package com.sk.thread;

public class Example12 {


    public static int counter=0;
    private static void process() throws InterruptedException {

        int size=20000;

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<size;i++){
                   // System.out.println(Thread.currentThread().getName());
                    counter++;
                }


            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<size;i++)
                {
                 //   System.out.println(Thread.currentThread().getName());
                    counter++;
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
