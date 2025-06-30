package com.sk.executor.example2;

import java.util.*;
import java.util.concurrent.*;

public class EmailSenderApp {

    static ExecutorService executor = Executors.newFixedThreadPool(3);

    public static CompletableFuture<String> sendEmailAsync(String email) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // simulate sending delay
                Thread.sleep(5000);
                if (email.contains("fail")) {
                    throw new RuntimeException("Failed to send: " + email);
                }
                return "Sent to: " + email;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupted while sending: " + email);
            }
        }, executor);
    }

    public static void main(String[] args) {
        List<String> emails = Arrays.asList("a@gmail.com", "b@gmail.com", "c@gmail.com");

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (String email : emails) {
            CompletableFuture<Void> future = sendEmailAsync(email)
                .thenAccept(result -> System.out.println(result))
                .exceptionally(ex -> {
                    System.err.println("Error: " + ex.getMessage());
                    return null;
                });

            futures.add(future);
        }

        // Wait for all tasks to complete
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        System.out.println("Main thread exiting...");

        executor.shutdown();
        System.out.println("Main thread exiting...");
    }
}
