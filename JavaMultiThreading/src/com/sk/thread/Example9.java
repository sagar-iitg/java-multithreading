package com.sk.thread;

public class Example9 {


    public static void main(String[] args) throws InterruptedException {



        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        Thread.sleep(10);
                        System.out.println("t1  "+" "+i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        Thread.sleep(100);
                        System.out.println("t2  "+" "+i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });

    t1.start();
    t2.start();
    t1.join();
    //t2.join();
    System.out.println("Finsihed");


    }
}
