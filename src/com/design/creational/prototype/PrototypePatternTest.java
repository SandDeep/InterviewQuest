package com.design.creational.prototype;

import java.util.List;

/**
 * Prototype pattern is used when the Object creation is a costly affair and
 * requires a lot of time and resources and you have a similar object already
 * existing. So this pattern provides a mechanism to copy the original object to
 * a new object and then modify it according to our needs. This pattern uses
 * java cloning to copy the object.example, suppose we have an Object that loads
 * data from database.
 * 
 * @author Deepesh
 * 
 */
public class PrototypePatternTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee emp = new Employee();
		emp.loadData();

		// Use the clone method to get the Employee object
		Employee emp1 = (Employee) emp.clone();
		Employee emp2 = (Employee) emp.clone();

		List<String> list = emp1.getEmpList();
		list.add("John");

		List<String> list1 = emp2.getEmpList();
		list1.remove("Pankaj");

		System.out.println("emps List: " + emp.getEmpList());
		System.out.println("empsNew List: " + list);
		System.out.println("empsNew1 List: " + list1);
	}
}
