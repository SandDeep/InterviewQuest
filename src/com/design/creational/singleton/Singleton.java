package com.design.creational.singleton;

import java.io.Serializable;

public class Singleton implements Serializable{

	private static final long serialVersionUID = -7604766932017737115L;
	
	// Method 1 : Exception Handling not possible
	// private static final Singleton object = new Singleton();

	/**
	 * Method 2 : eager initialization and static block initialization creates the instance
	 * even before it’s being used
	 */
	private static Singleton instance;
	/*static {
		try {
			obj = new Singleton();
		} catch (Exception e) {
			throw new RuntimeException(
					"Exception occured in creating singleton instance");
		}
	}

	public Singleton getInstance() {
		return obj;
	}*/
	
	/*
	 * Method 3 : Lazy initialization but fails in Multi-Threaded Environment.
	 */
	/*public static Singleton getInstance(){
		if(instance == null){
			instance=new Singleton();
		}
		return instance;
	}*/
	
	// Method 4 : Double Checked Locking
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	
	/*
	 * Method 5 : 
	 * Bill Pugh Singleton Implementation : When the singleton class is loaded,
	 * SingletonHelper class is not loaded into memory and only when someone
	 * calls the getInstance method, this class gets loaded and creates the
	 * Singleton class instance.
	 */
	private static class SingletonHelper{
		private static final Singleton instance=new Singleton();
	}
	
	public static Singleton getInnerInstance(){
		return SingletonHelper.instance;
	}
	
	/*
	 * Method 6 : 
	 * Java Enum values are globally accessible, so is the singleton. The
	 * drawback is that the enum type is somewhat inflexible; for example, it
	 * does not allow lazy initialization.
	 */
	// Private Constructor
	private Singleton() {
	}
}
