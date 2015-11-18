package com.design.creational.factory;

/**
 * 1. We can keep Factory class Singleton or we can keep the method that returns
 * the subclass as static.<br>
 * 2. Notice that based on the input parameter, different subclass is created
 * and returned.
 * 
 * @author Deepesh
 * 
 */
// Factory Class
public class ComputerFactory {

	public static Computer getComputer(String type, String ram, String hdd,
			String cpu) {

		if ("PC".equalsIgnoreCase(type)) {
			return new PC(ram, hdd, cpu);
		} else if ("Server".equalsIgnoreCase(type)) {
			return new PC(ram, hdd, cpu);
		}
		return null;
	}
}
