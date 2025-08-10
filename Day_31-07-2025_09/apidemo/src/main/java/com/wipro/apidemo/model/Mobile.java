package com.wipro.apidemo.model;

public class Mobile
{
	public int id;
	public String brand;
	public String modelNumber;
	public double price;
	
	
	public Mobile()
	{
		super();
	}

	public Mobile(int id,String brand, String modelNumber, double price) {
		super();
		this.id = id;
		this.brand = brand;
		this.modelNumber = modelNumber;
		this.price = price;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", brand=" + brand + ", modelNumber=" + modelNumber + ", price=" + price + "]";
	}

	
	
	
	
}
