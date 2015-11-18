package com.design.structural.decorator;

/**
 * Decorator pattern is helpful in providing runtime modification abilities and
 * hence more flexible. It’s easy to maintain and extend when the number of
 * choices are more. <br />
 * The disadvantage of decorator pattern is that it uses a lot of similar kind
 * of objects (decorators).
 * 
 * @author Deepesh
 * 
 */
public class DecoratorPatternTest {

	public static void main(String[] args) {
		Car sportCar = new SportsCar(new BasicCar());
		sportCar.assemble();

		System.out.println();

		Car luxurySportsCar = new LuxuryCar(new SportsCar(new BasicCar()));
		luxurySportsCar.assemble();
	}
}
