package com.sk.executor.example1;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        //validate order

        Callable<String > task1=()->{
            return  "validateOrder";
        };

        Callable<String > task2=()->{
            return  "payment";
        };

        Callable<String > task3=()->{
            return  "mail";
        };





    }
}
