package com.wipro.days5.projects;

public class FoodItem {
	
	String foodName;
    String foodType; 
    String cuisine; 
    double price;
	
    public FoodItem(String foodName, String foodType, String cuisine, double price) {
		super();
		this.foodName = foodName;
		this.foodType = foodType;
		this.cuisine = cuisine;
		this.price = price;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FoodItem [foodName=" + foodName + ", foodType=" + foodType + ", cuisine=" + cuisine + ", price=" + price
				+ "]";
	}
    
    
    
    
}
