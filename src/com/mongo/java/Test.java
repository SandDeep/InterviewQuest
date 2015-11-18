package com.mongo.java;

import ie.ucd.murmur.MurmurHash;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static int a = 10, b = 20;

	public static void main(String[] args) throws UnknownHostException {

		Test test = new Test();
		test.swap();

		List<String> list = new ArrayList<String>();
		list.add("37260271");
		list.add("Budget 2015");
		list.add("-2128958273");
		list.add("37260320");
		
		long hash = MurmurHash.hash64(list.toString(), 2, list.toString().length()-4);
		System.out.println(hash);
	}

	public void swap() {
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		System.out.println("a " + a + " b " + b);
	}

}
