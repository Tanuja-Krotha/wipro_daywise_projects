package com.wipro.test;

import com.wipro.oops.Converter;

public class ConverterTest {

	public static void main(String[] args) 
	{

		Converter converter = new Converter();

        int singleInt = converter.convert(5);        
        int twoInts = converter.convert(3, 7);       
        double doubleVal = converter.convert(2.5);    

        System.out.println("convert(int a): " + singleInt);
        System.out.println("convert(int a, int b): " + twoInts);
        System.out.println("convert(double a): " + doubleVal);
    }

	

}
