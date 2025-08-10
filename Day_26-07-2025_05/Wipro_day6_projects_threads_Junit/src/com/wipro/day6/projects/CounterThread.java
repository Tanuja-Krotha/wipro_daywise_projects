package com.wipro.day6.projects;

public class CounterThread extends Thread 
{
	Counter counter;

    public CounterThread(Counter counter) 
    {
        this.counter = counter;
    }
    
    public void run() 
    {
        for (int i = 0; i < 10; i++) 
        {
            counter.increment();
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


