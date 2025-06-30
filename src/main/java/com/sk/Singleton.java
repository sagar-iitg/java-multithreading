package com.sk;

public class Singleton {

    // intilai
    private static Singleton instance;
    private Singleton(){

    }
    public static  Singleton createInstance(){

        if(instance==null){
            try {
                Thread.sleep(10000); // simulate delay to trigger race condition
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance=new Singleton();
        }
        return  instance;
    }
}

class Main2{
    static Singleton instance3;

    public static void main(String[] args) {
//        Singleton instance = Singleton.createInstance();
//        Singleton instance1 = Singleton.createInstance();
//        System.out.println(instance1.hashCode());
//        System.out.println(instance.hashCode());

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                instance3 =Singleton.createInstance();
                System.out.println(instance3.hashCode());

            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                instance3=Singleton.createInstance();
                System.out.println(instance3.hashCode());
            }
        });
        t1.start();
        t2.start();


    }
}
