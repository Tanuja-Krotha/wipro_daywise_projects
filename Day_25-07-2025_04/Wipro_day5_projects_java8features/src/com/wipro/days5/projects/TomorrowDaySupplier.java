package com.wipro.days5.projects;

import java.time.LocalDate;
import java.util.function.Supplier;

public class TomorrowDaySupplier {
    public static void main(String[] args) {
        Supplier<String> tomorrowDay = () -> 
        {
            LocalDate tomorrow = LocalDate.now().plusDays(1);
            return tomorrow.getDayOfWeek().toString();
        };

        System.out.println("Tomorrow is: " + tomorrowDay.get());
    }
}

