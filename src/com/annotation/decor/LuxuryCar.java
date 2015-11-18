package com.annotation.decor;

public class LuxuryCar extends CarDecorator{

	public LuxuryCar(Car c) {
		super(c);
	}

	@Override
	public void assemble() {
		this.car.assemble();
		System.out.print("\tLuXury Car");
	}
	
}
