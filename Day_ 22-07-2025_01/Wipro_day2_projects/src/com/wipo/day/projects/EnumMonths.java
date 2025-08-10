package com.wipo.day.projects;

public class EnumMonths {

	public static void main(String[] args) {

		enum Month
		{
	        JANUARY,
	        FEBRUARY,
	        MARCH,
	        APRIL,
	        MAY,
	        JUNE,
	        JULY,
	        AUGUST,
	        SEPTEMBER,
	        OCTOBER,
	        NOVEMBER,
	        DECEMBER
	    }

	        for (Month m : Month.values()) 
	        {
	            System.out.println(m);
	        }


	        Month month = Month.FEBRUARY;

	       
	        if (month == Month.FEBRUARY)
	        {
	            System.out.println("The assigned month is FEBRUARY.");
	        } 
	        else
	        {
	            System.out.println("The assigned month is not FEBRUARY.");
	        }

	}

}
