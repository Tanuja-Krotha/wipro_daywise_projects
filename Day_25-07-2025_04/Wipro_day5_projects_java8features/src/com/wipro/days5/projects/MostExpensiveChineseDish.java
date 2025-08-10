package com.wipro.days5.projects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MostExpensiveChineseDish {
    public static void main(String[] args) {
        FoodItem f1 = new FoodItem("Spring Rolls", "Veg", "Chinese", 120);
        FoodItem f2 = new FoodItem("Chicken Manchurian", "Non Veg", "Chinese", 200);
        FoodItem f3 = new FoodItem("Pad Thai", "Veg", "Thai", 180);
        FoodItem f4 = new FoodItem("Paneer Tikka", "Veg", "Continental", 150);

        List<FoodItem> item = new ArrayList<>();
        item.add(f1);
        item.add(f2);
        item.add(f3);
        item.add(f4);

        
        Optional<FoodItem> expensiveChinese = 
        		item.stream()
                .filter(food -> food.cuisine.equalsIgnoreCase("Chinese"))
                .max(Comparator.comparingDouble(food -> food.price));

       
        if (expensiveChinese.isPresent()) 
        {
            System.out.println("Most Expensive Chinese Dish:");
            System.out.println(expensiveChinese.get());
        } 
        else {
            System.out.println("No Chinese dishes found.");
        }
    }
}
