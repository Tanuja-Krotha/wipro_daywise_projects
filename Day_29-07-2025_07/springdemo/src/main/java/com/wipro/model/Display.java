package com.wipro.model;

import org.springframework.stereotype.Component;

@Component
public class Display {
	private int size =6;
	
	public Display()
	{
		super();
	}
	public Display(int size)
	{
		super();
		this.size=size;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Display [size=" + size + "]";
	}
	
	

}
