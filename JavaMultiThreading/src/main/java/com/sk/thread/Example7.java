package com.sk.thread;

import java.lang.Thread;
import java.time.LocalDate;
import java.time.LocalTime;


class Runner1 implements  Runnable{



    private static  void execute(){
        for(int i=0;i<2000;i++)
        {
            System.out.println("Runner1 Class   "+i+Thread.currentThread()+"-- "+LocalTime.now());
        }
    }
    @Override
    public void run() {


        execute();
    }
}




class Runner2 implements  Runnable{



    private static  void execute(){
        for(int i=0;i<1000;i++)
        {
            System.out.println("Runner2 Class   "+i+Thread.currentThread()+ "-- "+LocalTime.now());
        }
    }
    @Override
    public void run() {

        execute();
    }
}
public class Example7 {


    public static void main(String[] args) {



        Thread t1=new Thread(new Runner1());
        Thread t2=new Thread(new Runner2());
        t1.setName("t1");
        t2.setName("t2");



        System.out.println("started");
        t2.start();
        t1.start();
    }

}
