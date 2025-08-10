package com.wipro.days5.projects;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.function.Consumer;

public class LondonTimePrinter {
    public static void main(String[] args) 
    {
        Consumer<ZoneId> timePrinter = 
        		zone ->
        {
            ZonedDateTime currentTime = ZonedDateTime.now(zone);
            System.out.println("Current time in " + zone + " is: " + currentTime.toLocalTime());
        };

        
        timePrinter.accept(ZoneId.of("Europe/London"));
    }
}

