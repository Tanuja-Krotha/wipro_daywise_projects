package com.wipro.oops;

public class RestaurantModel 
	{
		
			String restaurantId;
			String restaurantName;
			String restaurantLocation;
			
			public RestaurantModel()
			{
				
			}
			
			public RestaurantModel(String restaurantId, String restaurantName, String restaurantLocation) {
				super();
				this.restaurantId = restaurantId;
				this.restaurantName = restaurantName;
				this.restaurantLocation = restaurantLocation;
			}
			public String getRestaurantId() {
				return restaurantId;
			}
			public void setRestaurantId(String restaurantId) {
				this.restaurantId = restaurantId;
			}
			public String getRestaurantName() {
				return restaurantName;
			}
			public void setRestaurantName(String restaurantName) {
				this.restaurantName = restaurantName;
			}
			public String getRestaurantLocation() {
				return restaurantLocation;
			}
			public void setRestaurantLocation(String restaurantLocation) {
				this.restaurantLocation = restaurantLocation;
			}
			@Override
			public String toString() {
				return "RestaurantModel [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
						+ ", restaurantLocation=" + restaurantLocation + "]";
			}
			
			
		
	}
