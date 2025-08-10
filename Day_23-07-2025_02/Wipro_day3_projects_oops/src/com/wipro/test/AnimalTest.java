package com.wipro.test;

import com.wipro.oops.Animal;
import com.wipro.oops.Bird;
import com.wipro.oops.Dog;
import com.wipro.oops.Human;

public class AnimalTest {

	public static void main(String[] args) 
	{
		Animal human = new Human("Alice", 25);
        Animal bird = new Bird("Parrot", 2);
        Animal dog = new Dog("Max", 4);

        System.out.println("=== Human ===");
        human.displayInfo();
        human.makeSound();
        human.move();

        System.out.println("\n=== Bird ===");
        bird.displayInfo();
        bird.makeSound();
        bird.move();

        System.out.println("\n=== Dog ===");
        dog.displayInfo();
        dog.makeSound();
        dog.move();
    }


	

}
