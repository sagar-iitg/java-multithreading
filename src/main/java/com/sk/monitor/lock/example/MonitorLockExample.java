package com.sk.monitor.lock.example;

import com.sk.thread.Example;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MonitorLockExample {

    private static final Logger logger = Logger.getLogger(MonitorLockExample.class.getName());
    public synchronized void task1(){

        try{
            System.out.println("inside task1");
            Thread.sleep(10000);
        }catch (Exception e)
        {
            //exception handling here
           logger.log(Level.SEVERE,"in catch block",e);

        }


    }

    public void task2(){
        System.out.println("inside task2 but before synchronized");
        synchronized (this)
        {
            System.out.println("task2, inside synchronized block");
        }

    }

    public  void task3(){
        System.out.println("inside task3");
    }

    public static void main(String[] args) {
        MonitorLockExample obj=new MonitorLockExample();

        Thread thread1=new Thread(() ->{
        obj.task1();});

        Thread thread2=new Thread(obj::task2);

        Thread thread3=new Thread(obj::task3);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
