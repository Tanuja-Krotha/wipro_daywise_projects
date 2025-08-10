package com.wipro.test;

import com.wipro.oops.Circle;
import com.wipro.oops.Shape;
import com.wipro.oops.Square;
import com.wipro.oops.Rectangle;

public class ShapeTest {

	public static void main(String[] args) {

		Shape circle = new Circle(0,"RED",true,0.5);
		Shape square = new Square(4,"BLUE",true,5.5);
		Shape rectangle = new Rectangle(4,"YELLOW",true,6,7);
		
		System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);

	}

}
