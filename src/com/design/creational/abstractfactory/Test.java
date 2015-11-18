package com.design.creational.abstractfactory;

/**
 * <b>Benefits of Abstract Factory Pattern</b><br />
 * 1. Abstract Factory pattern provides approach to code for interface rather
 * than implementation.<br />
 * 2. Abstract Factory pattern is “factory of factories” and can be easily
 * extended to accommodate more products, for example we can add another
 * sub-class Laptop and a factory LaptopFactory.<br />
 * 3. Abstract Factory pattern is robust and avoid conditional logic of Factory
 * pattern.
 * 
 * @author Deepesh
 * 
 */
public class Test {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB",
				"500 GB", "2.4 GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory(
				"16 GB", "1 TB", "2.9 GHz"));

		System.out.println("Factory PC Config::" + pc);
		System.out.println("Factory Server Config::" + server);
	}
}
