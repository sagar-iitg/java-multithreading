package com.sk.interview.marriot;

class A {

    public synchronized void m1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " entered m1()");
        Thread.sleep(100_00); // simulate long-running task
        System.out.println(Thread.currentThread().getName() + " exiting m1()");
    }

    public synchronized void m2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " entered m2()");
        Thread.sleep(100_000);
        System.out.println(Thread.currentThread().getName() + " exiting m2()");
    }
}

class Main {
   public static void main(String[] args) {
       A a1 = new A();
       A a2 = new A();

       Thread t1 = new Thread(() -> {
           try {
               a1.m1();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       });
       Thread t2 = new Thread(() -> {
           try {
               a2.m1();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       });
//       Thread t3 = new Thread(() -> {
//           try {
//               a1.m2();
//           } catch (InterruptedException e) {
//               throw new RuntimeException(e);
//           }
//       });

       t1.start();
       t2.start();
       //t3.start();
   }
}
