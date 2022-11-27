package com.sk.thread;



class First extends  Thread{


    @Override
    public void run()
    {

        for(int i=0;i<200;i++)
            System.out.println("First"+i);

    }




}

class Second extends  Thread{


    @Override
    public void run()
    {

        for(int i=0;i<200;i++)
            System.out.println("Second"+i);

    }




}
public class Example8 {


    public static void main(String[] args) {

        Thread t1=new Thread(new First());
        Thread t2=new Thread(new Second());

        t1.start();
        t2.start();

    }
}
