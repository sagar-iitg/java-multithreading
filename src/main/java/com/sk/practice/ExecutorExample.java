package com.sk.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e= Executors.newFixedThreadPool(2);

        for(int i=1;i<=5;i++){
            int taskId=fun(i);
            e.submit(()->{
                System.out.println(Thread.currentThread()+"--"+taskId);
                    }
            );
            Thread.sleep(5000);
        }
        e.shutdown();

    }
    static int  fun(int i){
        return i*11;
    }
}
