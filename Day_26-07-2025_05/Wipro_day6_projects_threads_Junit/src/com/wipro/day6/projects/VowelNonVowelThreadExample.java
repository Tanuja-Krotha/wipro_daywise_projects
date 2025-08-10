package com.wipro.day6.projects;

import java.util.*;

public class VowelNonVowelThreadExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Amit", "Jayanta", "Esha", "Vinay", "Uma", "Kiran"));

        
        Runnable vowelTask = () -> {
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                char firstChar = Character.toLowerCase(name.charAt(0));
                if ("aeiou".indexOf(firstChar) != -1) {
                    names.set(i, name.toUpperCase());
                }
            }
        };

        
        Runnable nonVowelTask = () -> {
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                char firstChar = Character.toLowerCase(name.charAt(0));
                if ("aeiou".indexOf(firstChar) == -1) {
                    names.set(i, name.toLowerCase());
                }
            }
        };

        Thread t1 = new Thread(vowelTask);
        Thread t2 = new Thread(nonVowelTask);

        t1.start();
        t2.start();

        
        try {
            t1.join();
            t2.join();
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

        
        System.out.println("Final List:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
