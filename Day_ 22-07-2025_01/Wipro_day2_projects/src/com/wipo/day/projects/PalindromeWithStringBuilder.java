package com.wipo.day.projects;

public class PalindromeWithStringBuilder {

    public static void main(String[] args) {
        String input = "Madam"; 
        input = input.toLowerCase();
        StringBuilder sb = new StringBuilder(input);
        String reversed = sb.reverse().toString();
        if (input.equals(reversed)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}
