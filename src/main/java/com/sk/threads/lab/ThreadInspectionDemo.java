package com.sk.threads.lab;

public class ThreadInspectionDemo {

    public static void main(String[] args)
            throws Exception {

        System.out.println(
            "Main thread started"
        );

        Thread worker1 = new Thread(() -> {

            while (true) {

                System.out.println(
                    Thread.currentThread().getName()
                    + " working..."
                );

                try {
                    Thread.sleep(5000);
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

        }, "worker-1");


        Thread worker2 = new Thread(() -> {

            while (true) {

                System.out.println(
                    Thread.currentThread().getName()
                    + " processing..."
                );

                try {
                    Thread.sleep(7000);
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

        }, "worker-2");


        worker1.start();
        worker2.start();

        System.out.println(
            "Main thread sleeping..."
        );

        Thread.sleep(600000);
    }
}