package com.sk.executor.example2;

import java.util.concurrent.*;
import java.util.*;

public class CompletableFutureShutdownDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<String> emails = Arrays.asList("a@gmail.com", "b@gmail.com", "c@gmail.com");

        for (String email : emails) {
            CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000); // short delay
                    System.out.println("Sent to: " + email);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Interrupted: " + email);
                }
                return null;
            }, executor);
        }

        // ❌ NO join, no awaitTermination — main thread exits
        System.out.println("Main thread exiting...");

        executor.shutdown(); // triggers shutdown but does not wait
    }
}
