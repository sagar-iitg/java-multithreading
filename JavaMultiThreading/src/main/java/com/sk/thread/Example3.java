package com.sk.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Example3
{


    private static final int MAX_PASSWORD = 99;

    private static class Vault
    {
        private int password;

        public Vault(int password)
        {
            this.password=password;
        }

        public  boolean isCorrectPassword(int guess)
        {
            try{
                Thread.sleep(1000);

            }catch(InterruptedException e)
            {


            }
            return this.password==guess;
        }



    }

    public static  abstract  class HackerThread extends Thread
    {

        protected Vault vault;

        public HackerThread(Vault v)
        {
            this.vault=v;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start()
        {
            System.out.println("Starting thread"+this.getName());
            super.start();

        }

    }


    private static class AscendingHackerThread extends HackerThread
    {


        public AscendingHackerThread(Vault vault)
            {
                super(vault);
            }

            @Override
            public void run()
            {
                for(int guess=0; guess< MAX_PASSWORD; guess++)
                {

                        if(vault.isCorrectPassword(guess))
                        {
                            System.out.println(this.getName()+" guessed password is   "+ guess);
                            System.exit(0);
                        }
                }
            }

    }


    private static class DescendingHackerThread extends HackerThread
    {


        public DescendingHackerThread(Vault vault)
        {
            super(vault);
        }

        @Override
        public void run()
        {
            for(int guess=MAX_PASSWORD; guess>=0; guess--)
            {

                if(vault.isCorrectPassword(guess))
                {
                    System.out.println(this.getName()+" guessed password is   "+ guess);
                    System.exit(0);
                }
            }
        }

    }


    private static  class PoliceThread extends  Thread
    {
        @Override
        public void run()
        {


            for(int i=25;i>=0;i--)
            {

                try{

                    Thread.sleep(1000);

                }catch(InterruptedException e)
                {

                }
                System.out.println(i);
            }

            System.out.println("Game Over for you hackers");
            System.exit(0);

        }
    }
    public static void main(String[] args)
    {



        Random r=new Random();

        Vault v=new Vault(r.nextInt(MAX_PASSWORD));
        List<Thread> list=new ArrayList<>();
        list.add(new AscendingHackerThread(v));
        list.add(new DescendingHackerThread(v));
        list.add(new PoliceThread());


        for(Thread i:list)
        {
            i.getState();
            i.start();
        }


    }



}

