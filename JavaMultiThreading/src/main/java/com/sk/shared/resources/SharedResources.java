package com.sk.shared.resources;

public class SharedResources {

    public static void main(String[] args) {

        boolean itemAvailable=false;

        //synchronized put  the monitor lock

        public  synchronized void addItem(){
            itemAvailable=true;
            System.out.println("Item Added by: "+ Thread.currentThread().getName()+ "and invoking all threads which are waiting");
           // notifyAll();


        }

        public synchronized void consumeItem(){
            System.out.println("Consume Item method invoked by: "+ Thread.currentThread().getName());

            while (!itemAvailable)
            {
                try {
                    System.out.println("Thread "+ Thread.currentThread().getName()+" is waiting on");
                  //  wait();
                }
                catch (Exception e)
                {

                }
            }


        }

    }


}
