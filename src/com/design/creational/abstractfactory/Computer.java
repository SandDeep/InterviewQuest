package com.design.creational.abstractfactory;

/**
 * Factory design pattern is used when we have a super class with multiple
 * subclasses and based on input, we need to return one of the sub-class. This
 * pattern take out the responsibility of instantiation of a class from client
 * program to the factory class. Let’s first learn how to implement factory
 * pattern in java and then we will learn its benefits and we will see its usage
 * in JDK.
 * 
 * @author Deepesh
 * 
 */
// Super Class : Super class in factory pattern can be an interface, abstract
// class or a normal java class.
public abstract class Computer {

	public abstract String getRAM();

	public abstract String getHDD();

	public abstract String getCPU();

	@Override
	public String toString() {
		return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ",CPU="
				+ this.getCPU();
	}
}
