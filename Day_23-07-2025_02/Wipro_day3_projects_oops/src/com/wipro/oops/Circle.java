package com.wipro.oops;

public class Circle extends Shape {
	
	private double radius;

	public Circle (int numberOfSides, String color, boolean filled,double radius )
	{
		super(numberOfSides,color,filled);
		this.radius = radius;
		
	}
	
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}


	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", getNumberOfSides()=" + getNumberOfSides() + ", getColor()=" + getColor()
				+ ", isFilled()=" + isFilled() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}


	

	


	
	

}
