package com.wipro.oops;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Dog says: Woof woof!");
    }

    @Override
    public void move() {
        System.out.println("Dog runs on four legs.");
    }
}
