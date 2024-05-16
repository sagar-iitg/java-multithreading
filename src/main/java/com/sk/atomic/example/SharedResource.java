package com.sk.atomic.example;

import java.util.concurrent.atomic.AtomicInteger;

class SharedResource {

    AtomicInteger counter=new AtomicInteger(0);

    public void increment(){
        counter.getAndIncrement();
    }

    public int getCounter(){
        return counter.get();
    }
}

class Main{

        public static void main(String[] args) {

           SharedResource resource=new SharedResource();

            Thread t1=new Thread(()->{
                for (int i=0;i<20000;i++) resource.increment();
            });

            Thread t2=new Thread(()->{
                for (int i=0;i<20000;i++) resource.increment();
            });

            t1.start();
            t2.start();
            try {
                t1.join(); // Main thread will wait until t1 finishes
                t2.join();  // Main thread will wait until t2 finishes
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(resource.getCounter());


        }
}
