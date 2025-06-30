package com.sk.interview;

public class Practice{


    int n;
    int count=1;
    Practice(int n){
        this.n=n;
    }

     synchronized void printEven() throws InterruptedException {
        while (count<=n){
            if(count%2==0){
                System.out.println(count);
                count++;
                notifyAll();
            }else{
                wait();
             }
        }
         notifyAll();
    }
    synchronized void printOdd() throws InterruptedException {
        while (count<=n){
            if(count%2==1){
                System.out.println(count);
                count++;
                notifyAll();
            }else{
                wait();

            }
        }
        notifyAll();
    }
    public static void main(String[] args) {

        Practice p=new Practice(100);
        Thread evenThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.printEven();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Thread oddThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.printOdd();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        evenThread.start();
        oddThread.start();





    }

}
