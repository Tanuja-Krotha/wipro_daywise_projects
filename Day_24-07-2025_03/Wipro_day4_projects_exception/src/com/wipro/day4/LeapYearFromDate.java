package com.wipro.day4;
import java.util.Scanner;

public class LeapYearFromDate {

    
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter date in format yyyy-mm-dd: ");
        String date = sc.nextLine();

        int year = Integer.parseInt(date.substring(0, 4));

        if (isLeapYear(year)) {
            System.out.println("The year " + year + " is a Leap Year.");
        } else {
            System.out.println("The year " + year + " is not a Leap Year.");
        }

        sc.close();
    }
}
