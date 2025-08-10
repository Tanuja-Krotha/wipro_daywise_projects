package com.wipro.test;

import com.wipro.day4.InvalidMonthException;

public class TestMonth 
{
	public static void checkMonth(int month) throws InvalidMonthException {
        if (month < 1 || month > 12) 
        {
            throw new InvalidMonthException("Invalid month: " + month + ". Month must be between 1 and 12.");
        }
        else 
        {
            System.out.println("Valid month: " + month);
        }
    }

    
    public static void main(String[] args)
    {
        try
        {
            //checkMonth(15);  
            checkMonth(5);   
        } 
        catch (InvalidMonthException e) 
        {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

}
