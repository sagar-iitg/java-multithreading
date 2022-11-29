package com.sk.thread;



class DaemonThread  implements Runnable
{


    @Override
    public void run() {

        while(true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Daemeon Thread is running ");

        }

    }
}



class UserThread  implements Runnable
{


    @Override
    public void run() {



            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("User Thread finishes execution ");



    }
}
public class Example11 {


    public static void main(String[] args) {

        Thread t1=new Thread(new DaemonThread());
        Thread t2=new Thread(new UserThread());
        t1.setDaemon(true);
       t1.start();
       t2.start();




    }
}
