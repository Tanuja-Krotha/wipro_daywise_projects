package com.wipro.days5.projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChineseFoodFilter 
{
	public static void main(String[] args)
	{
	
	FoodItem f1 = new FoodItem("Spring Rolls", "Veg", "Chinese", 120);
	FoodItem f2 = new FoodItem("Chicken Manchurian", "Non Veg", "Chinese", 200);
	FoodItem f3 = new FoodItem("Pad Thai", "Veg", "Thai", 180);
	FoodItem f4 = new FoodItem("Paneer Tikka", "Veg", "Continental", 150);
	
	List<FoodItem> item = new ArrayList<>();
	item.add(f1);
	item.add(f2);
	item.add(f3);
	item.add(f4);
	
	List<FoodItem> chineseItems = item.stream()
            .filter(food -> food.cuisine.equalsIgnoreCase("Chinese"))
            .collect(Collectors.toList());

    
    System.out.println("Chinese Food Items:");
    for (FoodItem f : chineseItems) {
        System.out.println(f);
        }

	 
	}

}
