package com.wipro.day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyMapExample {

	public static void main(String[] args) {

		Map<String, String> currencyMap = new HashMap<>();
        currencyMap.put("INR", "Indian Rupee");
        currencyMap.put("USD", "United States Dollar");
        currencyMap.put("EUR", "Euro");
        currencyMap.put("JPY", "Japanese Yen");
        currencyMap.put("GBP", "British Pound");

       
        List<Map.Entry<String, String>> entryList = new ArrayList<>(currencyMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        System.out.println("Sorted Currency Codes by Name:");
        for (Map.Entry<String, String> entry : entryList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
	}

}
