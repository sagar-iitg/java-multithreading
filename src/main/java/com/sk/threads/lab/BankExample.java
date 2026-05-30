package com.sk.threads.lab;

public class BankExample {

    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Runnable task = () -> {

            System.out.println(Thread.currentThread().getName()
                    + " trying to enter");

            synchronized (lock) {

                System.out.println(Thread.currentThread().getName()
                        + " entered critical section");

                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                }

                System.out.println(Thread.currentThread().getName()
                        + " leaving");
            }
        };

        Thread t1 = new Thread(task, "PAYMENT-THREAD");
        Thread t2 = new Thread(task, "REFUND-THREAD");

        t1.start();

        Thread.sleep(1000);

        t2.start();
        while (true) {
            Thread.sleep(1000);
        }
    }
}