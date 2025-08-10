package com.wipro.day7.projects;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortStringList {
    public static void main(String[] args) {
        
        List<String> names = Arrays.asList("Ravi", "Anita", "Zara", "Mohan", "Geeta");

        
        List<String> sortedNames = names.stream()
                .sorted(String::compareTo) 
                .collect(Collectors.toList());

        
        System.out.println("Sorted Names:");
        sortedNames.forEach(System.out::println);
    }
}

