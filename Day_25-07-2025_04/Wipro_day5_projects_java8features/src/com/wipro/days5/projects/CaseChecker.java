package com.wipro.days5.projects;
import java.util.Scanner;
import java.util.function.Predicate;

public class CaseChecker {

	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Predicate<String> isUpperCase = str -> str.equals(str.toUpperCase()) && !str.isEmpty();
        Predicate<String> isLowerCase = str -> str.equals(str.toLowerCase()) && !str.isEmpty();
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        if (isUpperCase.test(input)) 
        {
            System.out.println("The string is in UPPERCASE.");
        } else if (isLowerCase.test(input)) 
        {
            System.out.println("The string is in lowercase.");
        } else 
        {
            System.out.println("The string is mixed case or contains non-alphabetic characters.");
        }
        sc.close();

	}

}
