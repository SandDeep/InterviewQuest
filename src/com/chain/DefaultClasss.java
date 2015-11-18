package com.chain;

import com.annotation.AccessClass;

public class DefaultClasss extends AccessClass implements Cloneable{

	public DefaultClasss() {
		System.out.println("DefaultClasss");
	}

	public static void main(String[] args) {
		DefaultClasss classs = new DefaultClasss();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
