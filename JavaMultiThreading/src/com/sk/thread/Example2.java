package com.sk.thread;

public class Example2
{

    public static void main(String[] args) {


        Thread t= new NewThread();
        t.setName("now-now");
        t.start();
    }

    private static class NewThread extends  Thread
    {

        @Override
        public  void run()
        {
            this.setPriority(8);
            System.out.println("Hello From "+this.getName());
            this.setName("MyThread");

            System.out.println("Hello From "+this.getName());
            System.out.println(  this.getPriority());


        }




    }

}
