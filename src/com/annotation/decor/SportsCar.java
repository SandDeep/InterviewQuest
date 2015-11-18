package com.annotation.decor;

public class SportsCar extends CarDecorator{

	public SportsCar(Car c) {
		super(c);
	}

	@Override
	public void assemble() {
		//super.assemble();
		this.car.assemble();
		System.out.print("\tSports Car");
	}
	
}
