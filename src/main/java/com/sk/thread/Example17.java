package com.sk.thread;


import java.util.ArrayList;
import java.util.List;

class Processor
{


    private List<Integer> list=new ArrayList<>();
    private static final int UPPER_LIMIT=5;
    private static final int LOWER_LIMIT=0;
    private final Object lock=new Object();
    private int value=1;
    public void producer() throws InterruptedException
    {

        synchronized (lock)
        {
            while (true)
            {
                if(list.size()==UPPER_LIMIT)
                {
                    System.out.println("waiting for removing item.....");
                   lock.wait();
                }
                else
                {
                    System.out.println("Adding elements in array is: "+value);
                    list.add(value);
                    value++;
                    lock.notify();

                }
                Thread.sleep(1000);
            }
        }

    }

    public void consume() throws  InterruptedException
    {

        synchronized (lock)
        {
            while (true)
            {
                if(list.size()==LOWER_LIMIT)
                {
                    System.out.println("waiting for adding item.....");
                    value=1;
                    lock.wait();
                }
                else
                {
                    System.out.println("Removing the last item "+list.remove(list.size()-1));

                    lock.notify();

                }
                Thread.sleep(1000);
            }
        }

    }

}
public class Example17
{


    public static void main(String[] args) {



        Processor p=new Processor();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        t1.start();
        t2.start();
    }





}
