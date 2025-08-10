package com.wipro.oops;

public class Bird extends Animal {

	public Bird(String name, int age) {
		super(name, age);
	}

	@Override
	public void makeSound() {
		System.out.println("Bird says: Tweet tweet!");
	}

	@Override
	public void move() {
		System.out.println("Bird flies in the sky.");
	}

}
