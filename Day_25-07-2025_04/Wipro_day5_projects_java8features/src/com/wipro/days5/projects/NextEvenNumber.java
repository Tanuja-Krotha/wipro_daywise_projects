package com.wipro.days5.projects;

import java.util.function.Consumer;

public class NextEvenNumber {
    public static void main(String[] args) {
        Consumer<Integer> nextEvenPrinter = 
num -> {
            if (num % 2 == 0) 
            {
                System.out.println(num + 2);
            } else 
            {
                System.out.println(num + 1);
            }
        };

       
        nextEvenPrinter.accept(5);    
        nextEvenPrinter.accept(100);  
    }
}

