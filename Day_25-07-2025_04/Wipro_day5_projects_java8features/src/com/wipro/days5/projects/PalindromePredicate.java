package com.wipro.days5.projects;

import java.util.function.Predicate;

public class PalindromePredicate {
    public static void main(String[] args) {

       
        Predicate<String> isPalindrome =
        		s -> 
        {
           
            return s.equalsIgnoreCase( new StringBuilder(s).reverse().toString());
        };

       
        String input1 = "level";
        String input2 = "world";
        
        System.out.println("Is '" + input1 + "' a palindrome? " + isPalindrome.test(input1));
        System.out.println("Is '" + input2 + "' a palindrome? " + isPalindrome.test(input2));
    }
}
