package com.wipro.test;

import com.wipro.day4.Box;

public class BoxTxet {

	public static void main(String[] args) {
		
		Box<Integer> intBox = new Box<>();
        intBox.setItem(100);
        System.out.println("Integer Value: " + intBox.getItem());

        
        Box<String> strBox = new Box<>();
        strBox.setItem("Hello");
        System.out.println("String Value: " + strBox.getItem());

        
        Box<Double> doubleBox = new Box<>();
        doubleBox.setItem(3.14);
        System.out.println("Double Value: " + doubleBox.getItem());

	}

}
