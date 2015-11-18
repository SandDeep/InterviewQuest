package com.mongo.decorator;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car car) {
		super(car);
	}

	@Override
	public void assemble() {
		super.assemble();
		//car.assemble();
		System.out.println("Adding Feautres of Luxury Car");
	}
}
