package com.wipo.day.projects;

public class PalindromeCheck {

    public static void main(String[] args) {
        String input = "Madam"; 
        input = input.toLowerCase();
        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++)
        {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) 
        {
            System.out.println("The string is a palindrome.");
        }
        else 
        {
            System.out.println("The string is not a palindrome.");
        }
    }
}
