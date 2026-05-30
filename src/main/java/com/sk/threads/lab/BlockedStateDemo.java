package com.sk.threads.lab;

public class BlockedStateDemo {

    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {

            synchronized (lock) {

                System.out.println("Thread-1 acquired lock");

                try {
                    Thread.sleep(15000); // hold lock for 15 sec
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread-1 releasing lock");
            }

        }, "THREAD-1");


        Thread t2 = new Thread(() -> {

            System.out.println("Thread-2 trying to acquire lock");

            synchronized (lock) {

                System.out.println("Thread-2 acquired lock");
            }

        }, "THREAD-2");


        t1.start();

        Thread.sleep(1000);

        t2.start();
    }
}