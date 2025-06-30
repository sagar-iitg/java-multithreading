package com.sk.executor.example1;

import java.util.concurrent.*;

public class SubmitExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(2);

        Callable<String> task=()->{
            Thread.sleep(10);
            return "Task 1 completed";
        };

        Future<String> future = executor.submit(task);
        System.out.println("Doing other work...");
        String result = future.get(); // blocks until task is complete
        System.out.println("Result: " + result);

        executor.shutdown();
        System.out.println(Runtime.getRuntime().availableProcessors());





    }
}
