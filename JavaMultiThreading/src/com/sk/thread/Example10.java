package com.sk.thread;

public class Example10 {


    public static void main(String[] args)
    {

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().isDaemon());
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(Thread.currentThread().isInterrupted());


    }
}
