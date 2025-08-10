package com.wipro.day4;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeCalculator {

    public static int getAge(LocalDate birthDate) 
    {
        LocalDate today = LocalDate.now();
        if ((birthDate != null) && (!birthDate.isAfter(today))) 
        {
            return Period.between(birthDate, today).getYears();
        } 
        else 
        {
            return 0;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your birth date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        try 
        {
            LocalDate birthDate = LocalDate.parse(input);
            int age = getAge(birthDate);
            System.out.println("You are " + age + " years old.");
        } 
        catch (Exception e) 
        {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
        sc.close();
    }
    
    
}

