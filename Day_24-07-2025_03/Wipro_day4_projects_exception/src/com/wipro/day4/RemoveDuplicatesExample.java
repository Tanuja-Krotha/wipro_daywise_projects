package com.wipro.day4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesExample {
    public static void main(String[] args) {
        
        List<Integer> numbers = new ArrayList<>();
        numbers.add(18);
        numbers.add(10);
        numbers.add(12);
        numbers.add(24);
        numbers.add(4);
        numbers.add(10);

        System.out.println("Original List: " + numbers);
        Set<Integer> uniqueSet = new HashSet<>(numbers);
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        System.out.println("List after removing duplicates: " + uniqueList);
    }
}
