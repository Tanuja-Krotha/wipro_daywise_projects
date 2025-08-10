package com.wipro.days5.tests;

import com.wipro.days5.projects.Multiply;

public class TestFIMul {

	public static void main(String[] args) 
	{
		Multiply mul = (a, b) -> a * b;
        int result = mul.multiply(6, 4);
        System.out.println("Multiplication result: " + result);
	}

}
