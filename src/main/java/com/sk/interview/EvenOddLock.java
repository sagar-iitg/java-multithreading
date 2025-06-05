package com.sk.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddLock {

    private int counter = 1;
    private final int limit;
    private final Lock lock = new ReentrantLock();
    private final Condition evenCondition = lock.newCondition();
    private final Condition oddCondition = lock.newCondition();

    public EvenOddLock(int limit) {
        this.limit = limit;
    }

    public void printEven() {
        while (true) {
            lock.lock();
            try {
                while (counter <= limit && counter % 2 != 0) {
                    evenCondition.await();  // wait if it's not even's turn
                }
                if (counter > limit) break;

                System.out.println("Even: " + counter);
                counter++;
                oddCondition.signal();  // wake up odd thread
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    public void printOdd() {
        while (true) {
            lock.lock();
            try {
                while (counter <= limit && counter % 2 == 0) {
                    oddCondition.await();  // wait if it's not odd's turn
                }
                if (counter > limit) break;

                System.out.println("Odd: " + counter);
                counter++;
                evenCondition.signal();  // wake up even thread
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        EvenOddLock obj = new EvenOddLock(100);

        Thread evenThread = new Thread(obj::printEven, "Even-Thread");
        Thread oddThread = new Thread(obj::printOdd, "Odd-Thread");

        evenThread.start();
        oddThread.start();
    }
}
