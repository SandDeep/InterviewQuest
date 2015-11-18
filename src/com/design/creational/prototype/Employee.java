package com.design.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable {

	private List<String> empList;

	public Employee() {
		empList = new ArrayList<String>();
	}

	public Employee(List<String> empList) {
		this.empList = empList;
	}

	public void loadData() {
		empList.add("Pankaj");
		empList.add("Raj");
		empList.add("David");
		empList.add("Lisa");
	}

	public List<String> getEmpList() {
		return empList;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<String>();

		for (String emp : empList) {
			temp.add(emp);
		}
		return new Employee(temp);
	}

}
