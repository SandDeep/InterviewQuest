package com.annotation;

import com.pkg1.Fibo;

/**
 * The fundamental idea behind an enum is that there is one, and only one,
 * instance of each of its members. This is what lets you safely compare them
 * for equality, without fear that there's another SINGLE or MULTIPLE created in
 * some other place.
 * 
 * @author Deepesh.Maheshwari
 *
 */
public enum Operation {

	SINGLE, MULTIPLE;

	private Type operation;

	public void setOperation(Type operation) {
		this.operation = operation;
	}

	public Type getOperation() {
		return operation;
	}

	/**
	 * instances are implicitly static and final.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Operation oper1 = Operation.SINGLE;
		oper1.setOperation(Type.GET);

		Operation oper2 = Operation.MULTIPLE;
		oper2.setOperation(Type.POST);

		Operation oper3 = Operation.SINGLE;
		oper3.setOperation(Type.POST);

		System.out.println(oper1 +" "+oper1.getOperation());
		System.out.println(oper2 +" "+oper2.getOperation());
		System.out.println(oper3 +" "+oper3.getOperation());
	}
}

enum Type {
	POST, GET;
}

class TestFunc {

	final Fibo fibo;

	public TestFunc() {
		fibo = new Fibo();
	}
	
	/*public void ex(){
		fibo=new Fibo();
	}*/
}
