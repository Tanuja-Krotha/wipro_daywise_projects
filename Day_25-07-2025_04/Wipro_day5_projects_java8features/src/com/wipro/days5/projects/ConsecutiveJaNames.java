package com.wipro.days5.projects;

import java.util.*;
import java.util.stream.Collectors;

public class ConsecutiveJaNames {
    public static void main(String[] args) 
    {
        List<String> names = Arrays.asList("Jayanta", "Jnanedra", "Tanuja", "Ravi", "Ajay", "Kiran");

        List<String> result = names.stream()
                .filter(name -> name.toLowerCase().contains("ja"))
                .peek(name -> System.out.println(name))
                .collect(Collectors.toList());

        
        }
    }

