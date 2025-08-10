package com.wipro.day4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatExample {
    public static void main(String[] args) {
        
        LocalDate date = LocalDate.of(2023, 11, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        String formattedDate = date.format(formatter);
        System.out.println(formattedDate);
    }
}

