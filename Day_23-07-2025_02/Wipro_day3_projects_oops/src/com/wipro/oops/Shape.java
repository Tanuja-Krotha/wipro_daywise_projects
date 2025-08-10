package com.wipro.oops;

public class Shape {
	
	private int numberOfSides;
	private String color;
    private boolean filled;
	
    public Shape()
    {
    	
    }
    
    public Shape(int numberOfSides, String color, boolean filled) {
		super();
		this.numberOfSides = numberOfSides;
		this.color = color;
		this.filled = filled;
	}
    
    
    
    public int getNumberOfSides() {
		return numberOfSides;
	}
	public void setNumberOfSides(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	@Override
	public String toString() {
		return "Shape [numberOfSides=" + numberOfSides + ", color=" + color + ", filled=" + filled + "]";
	}
	
    
    

}
