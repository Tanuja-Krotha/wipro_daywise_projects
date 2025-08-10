package com.wipro.oops;

public class Rectangle extends Shape {
	
	double length;
	double width;
	
	public Rectangle (int numberOfSides, String color, boolean filled,double length, double width )
	{
		super(numberOfSides,color,filled);
		this.length = length;
		this.width = width;
		
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + ", getNumberOfSides()=" + getNumberOfSides()
				+ ", getColor()=" + getColor() + ", isFilled()=" + isFilled() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	

}
