package com.sk.executor.example2;

import java.util.concurrent.*;

public class OrderProcessing {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(3);

        Callable<String > validateOrder=()->{
            //Thread.sleep(1000);
            Thread.sleep(5000);
            System.out.println(Thread.currentThread());
            return "Order Validated";
        };
        Callable<String> chargePayment = () -> {
            //Thread.sleep(300);
            Thread.sleep(5000);
            System.out.println(Thread.currentThread());
            return "Payment Charged";
        };

        Callable<String> sendEmail = () -> {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread());
            return "Confirmation Email Sent";
        };
        System.out.println(Thread.currentThread());

        Future<String> f1 = executor.submit(validateOrder);
        Future<String> f2 = executor.submit(chargePayment);
        Future<String> f3 = executor.submit(sendEmail);
        // Wait for all tasks to complete
        System.out.println("Waiting for all tasks...");
        System.out.println(f1.get());
        System.out.println("jjjj");
        System.out.println(f2.get());
        System.out.println("xyz");
        System.out.println(f3.get());
        System.out.println("kdksksksk");
        System.out.println("✅ Order processing complete!");

        executor.shutdown();

    }
}
