package com.wipro.days5.projects;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
    	Optional<Integer> optionalInt = Optional.ofNullable(null);
    	optionalInt.ifPresentOrElse(
    	            value -> System.out.println("Value is: " + value),
    	            () -> System.out.println("No value present")
    	        );

        
        
    }
}
