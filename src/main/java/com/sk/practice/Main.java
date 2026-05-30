package com.sk.practice;

class MyThread extends Thread {

    @Override
    public void run() {


        for (int i = 1; i <= 5; i++)
        {

            System.out.println(
                Thread.currentThread().getName()
                + " -> Child Thread : " + i
            );

            try
            {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        MyThread t = new MyThread();

        t.start();

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                Thread.currentThread().getName()
                + " -> Main Thread : " + i
            );

        }
    }
}