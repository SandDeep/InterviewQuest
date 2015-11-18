package com.annotation;

public class LazyEnumTest {
	// System.out.println("Accessing enum...");
	static LazySingleton lazy = LazySingleton.INSTANCE;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Sleeping for 5 seconds...");
		Thread.sleep(5000);
		System.out.println("Accessing enum...");
		LazySingleton lazy = LazySingleton.INSTANCE;
		System.out.println("Done.");
	}
}

enum LazySingleton {
	INSTANCE;

	static {
		System.out.println("Static Initializer");
	}
}