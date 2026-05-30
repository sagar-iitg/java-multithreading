package com.sk.threads.lab;

public class ProcessThreadDemo {

    public static void main(String[] args)
            throws Exception {

        System.out.println(
            "Main thread started"
        );

        Thread worker = new Thread(() -> {

            while (true) {

                System.out.println(
                    Thread.currentThread().getName()
                    + " is running"
                );

                try
                {

                    Thread.sleep(3000);

                }
                catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });

        worker.start();

        System.out.println(
            "Main thread finished"
        );

        Thread.sleep(600000);
    }
}