package com.wipro.days5.projects;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringLengths {
    public static void main(String[] args) {
        Function<List<String>, List<Integer>> getLengths = list ->
            list.stream()
                .map(String::length)
                .collect(Collectors.toList());

        List<String> input = Arrays.asList("Jayanta", "Amit", "Vasu");
        List<Integer> result = getLengths.apply(input);

        System.out.println(result);  
    }
}

