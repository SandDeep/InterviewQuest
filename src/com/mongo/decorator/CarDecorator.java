package com.mongo.decorator;

public class CarDecorator implements Car {

	/* Component variable should be accessible to the child decorator classes */
	protected Car car;

	public CarDecorator(Car car) {
		this.car = car;
	}

	@Override
	public void assemble() {
		this.car.assemble();
	}

}
