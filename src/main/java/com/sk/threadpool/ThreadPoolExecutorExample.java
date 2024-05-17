package com.sk.threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {


        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(
                1,
                1,
                1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj = poolExecutor.submit(() -> {
            System.out.println("this is task , thread is running");
        });
        System.out.println(futureObj.isDone());
    }
}
