package com.wipro.oops;

public class Square extends Shape {
	
	double side;
	
	public Square (int numberOfSides, String color, boolean filled,double side )
	{
		super(numberOfSides,color,filled);
		this.side = side;
		
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "Square [side=" + side + ", getNumberOfSides()=" + getNumberOfSides() + ", getColor()=" + getColor()
				+ ", isFilled()=" + isFilled() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	
	
	
	

}
