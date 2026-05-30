package com.sk.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiplePoolExample {

    public static void main(String[] args) {

        ExecutorService paymentPool =
                Executors.newFixedThreadPool(
                        2,
                        r -> new Thread(r, "payment-worker")
                );

        ExecutorService emailPool =
                Executors.newFixedThreadPool(
                        2,
                        r -> new Thread(r, "email-worker")
                );

        // payment tasks
        for (int i = 1; i <= 5; i++) {

            int orderId = i;

            paymentPool.submit(() -> {

                System.out.println(
                        Thread.currentThread().getName()
                                + " processing payment for order "
                                + orderId
                );

                sleep(2000);
            });
        }

        // email tasks
        for (int i = 1; i <= 5; i++) {

            int orderId = i;

            emailPool.submit(() -> {

                System.out.println(
                        Thread.currentThread().getName()
                                + " sending email for order "
                                + orderId
                );

                sleep(8000); // intentionally slow
            });
        }

        paymentPool.shutdown();
        emailPool.shutdown();
    }

    static void sleep(int ms) {

        try {
            Thread.sleep(ms);
        } catch (Exception e) {
        }
    }
}