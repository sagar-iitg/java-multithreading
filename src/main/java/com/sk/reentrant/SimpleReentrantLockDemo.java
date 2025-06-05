package com.sk.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class SimpleReentrantLockDemo {

    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock(); // Shared lock

    public void increment() {
        lock.lock(); // Acquire lock
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " -> " + counter);
        } finally {
            lock.unlock(); // Always release lock
        }
    }

    public static void main(String[] args) {
        SimpleReentrantLockDemo obj = new SimpleReentrantLockDemo();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                obj.increment();
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        Thread t2 = new Thread(task, "Thread-B");
        Thread t1 = new Thread(task, "Thread-A");


        t1.start();
        t2.start();
    }
}
