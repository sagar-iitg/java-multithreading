package com.sk;

public class EvenOdd {

    //instance variable
    int n;
    int count=1;
    EvenOdd(int n){
        this.n=n;
    }
    synchronized void even() throws InterruptedException {

        while(count<=n){

            if(count%2==0){
                System.out.println(count+ "--"+Thread.currentThread());
                count++;
              notify();
            }else{
              wait();
            }
        }
    }
   synchronized void odd() throws InterruptedException {
        while(count<=n){

            if(count%2==1){
                System.out.println(count+ "--"+Thread.currentThread());
                count++;
                notify();
            }else{
                wait();
            }
        }
    }
    public static void main(String[] args) {

        EvenOdd obj=new EvenOdd(100);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.even();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.setName("even");

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.odd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2.setName("odd");

        t1.start();
        t2.start();

    }
}
