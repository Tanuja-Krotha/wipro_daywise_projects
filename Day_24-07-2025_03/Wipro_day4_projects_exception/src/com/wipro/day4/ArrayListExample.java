package com.wipro.day4;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();

        
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        System.out.println("Original List: " + numbers);

        
        numbers.remove(2);

        System.out.println("After removing index 2: " + numbers);

        
        numbers.add(60);

        System.out.println("After adding 60 at the end: " + numbers);

	}

}
