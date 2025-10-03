package com.sk.interview;

import com.sk.EvenOdd;

public class EvenOddPractice {

    int counter=1;
    int limit=0;
    EvenOddPractice(int limit){
        this.limit=limit;
    }
    synchronized void even() throws InterruptedException {

        while(counter<=limit){

            if(counter%2==0){
                System.out.println(counter);
                counter++;
                notify();
            }else {
                wait();
            }
        }
        notify();
    }
    synchronized void odd() throws InterruptedException {

        while(counter<=limit){

            if(counter%2!=0){
                System.out.println(counter);
                counter++;
                notify();
            }else {
                wait();
            }
        }
        notify();
    }

    public static void main(String[] args) {

        EvenOddPractice evenOddPractice=new EvenOddPractice(100);

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    evenOddPractice.even();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    evenOddPractice.odd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
