package com.sk.thread;

public class Example5 {


    public static void main(String[] args) {

        Thread t=new Thread(new BlockingTask());
        t.start();
        t.interrupt();

    }

    private static  class BlockingTask implements Runnable
    {


        @Override
        public void run()
        {

            try {
                Thread.sleep(100000);
            }
            catch (InterruptedException e){
                System.out.println("Blocking thread");
            }
        }
    }
}
