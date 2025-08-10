package com.wipro.oops;

public class Human extends Animal {

	public Human(String name, int age) 
	{
		super(name, age);	
	}

	@Override
	public void makeSound() {
		System.out.println("Human says: Hello!");	
	}

	@Override
	public void move() {
		 System.out.println("Human walks on two legs.");
		
	}

}
