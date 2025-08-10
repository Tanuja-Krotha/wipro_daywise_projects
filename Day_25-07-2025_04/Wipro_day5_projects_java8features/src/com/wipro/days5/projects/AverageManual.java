package com.wipro.days5.projects;

import java.util.*;

public class AverageManual {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        
        int sum = numbers.stream()
                .map(n -> n) 
                .reduce(0, (a, b) -> a + b);
        
        long count = numbers.stream()
                .map(n -> n)
                .count();

        double average = count > 0 ? (double) sum / count : 0;
        System.out.println("Average: " + average);
    
    
      /*  Double average = numbers.stream()
                .map(n -> n)  
                .collect(Collectors.averagingInt(n -> n));

        System.out.println("Average: " + average);*/
    
    }
}

