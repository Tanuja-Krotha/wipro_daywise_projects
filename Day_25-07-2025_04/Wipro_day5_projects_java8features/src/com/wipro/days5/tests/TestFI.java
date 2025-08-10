package com.wipro.days5.tests;

import com.wipro.days5.projects.GreetOps;

public class TestFI 
	{
	 public static void main(String[] args) {
	       
	        GreetOps greet = () -> {System.out.println("Hello Lambda");};
	        greet.sayHello();
	    }
	
	}
