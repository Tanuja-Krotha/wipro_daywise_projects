package com.wipro.day6.projects;
class NumberThread extends Thread {
    public void run() 
    {
        for (int i = 1; i <= 10; i++) 
        {
            System.out.println("Number: " + i);
            try 
            {
                Thread.sleep(1000); 
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}

class AlphabetThread extends Thread 
{
    public void run() 
    {
        for (char ch = 'A'; ch <= 'J'; ch++) 
        {
            System.out.println("Alphabet: " + ch);
            try 
            {
                Thread.sleep(1000); 
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}

public class ConcurrentThreadsUsingExtend 
{
    public static void main(String[] args)
    {
        NumberThread numThread = new NumberThread();
        AlphabetThread alphaThread = new AlphabetThread();

        numThread.start();
        alphaThread.start();
    }
}
