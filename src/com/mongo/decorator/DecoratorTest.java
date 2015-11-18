package com.mongo.decorator;

public class DecoratorTest {

	public static void main(String[] args) {
		Car car=new SportsCar(new BasicCar());
		car.assemble();
		
		car=new LuxuryCar(new SportsCar(new BasicCar()));
		car.assemble();
	}
}
