package com.sk.atomic;


class SharedResource{
    int counter;

    public void  increment(){
        counter++;
    }
    public int getCounter(){
        return counter;
    }

}
class AtomicExampleWithoutThread {

    public static void main(String[] args) {
        SharedResource resource=new SharedResource();
        for(int i=0;i<400;i++){
            resource.increment();
        }
        System.out.println(resource.getCounter());
    }



}
