package com.sk.interview;

public class EvenOdd {


    volatile static int counter=1;
    int limit=0;

    EvenOdd(int limit){
        this.limit=limit;
    }
    public synchronized void printEven() throws InterruptedException {

        while (counter<=limit){
            if(counter%2==0){
                System.out.println(counter);
                counter++;
                notifyAll();
            }
            else{
                wait();
            }

        }

    }

    public synchronized void printOdd() throws InterruptedException {

        while (counter<=limit){
            if(counter%2==1){
                System.out.println(counter);
                counter++;
                notifyAll();
            }
            else{
                wait();
            }

        }

    }






    public static void main(String[] args){

        EvenOdd obj=new EvenOdd(100);
        Thread evenThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread oddThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        evenThread.start();
        oddThread.start();





    }
}
