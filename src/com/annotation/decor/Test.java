package com.annotation.decor;

public class Test {

	public static void main(String[] args) {
		Car sportsCar=new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n********");
		Car luxuryCar=new LuxuryCar(sportsCar);
		luxuryCar.assemble();
	}
}
