package com.design.structural.adapter;

/**
 * Adapter design pattern is one of the structural design pattern and it’s used
 * so that two unrelated interfaces can work together. The object that joins
 * these unrelated interface is called an <b>Adapter</b>. <br/>
 * As a real life example, we can think of a mobile charger as an adapter
 * because mobile battery needs 3 volts to charge but the normal socket produces
 * either 120V (US) or 240V (India). So the mobile charger works as an adapter
 * between mobile charging socket and the wall socket.
 * 
 * @author Deepesh
 * 
 */
public class AdapterPatternTest {

	public static void main(String[] args) {

		AdapterPatternTest patternTest = new AdapterPatternTest();
		patternTest.testClassAdapter();
		patternTest.testObjectAdapter();
	}

	private void testObjectAdapter() {
		SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
		Volt v3 = sockAdapter.get3Volt();
		Volt v12 = sockAdapter.get12Volt();
		Volt v120 = sockAdapter.get120Volt();

		System.out.println("v3 volts using Object	Adapter = " + v3.getVolts());
		System.out
				.println("v12 volts using Object	Adapter = " + v12.getVolts());
		System.out.println("v120 volts using Object	Adapter = "
				+ v120.getVolts());
	}

	private void testClassAdapter() {
		SocketAdapter sockAdapter = new SocketClassAdapterImpl();
		Volt v3 = sockAdapter.get3Volt();
		Volt v12 = sockAdapter.get12Volt();
		Volt v120 = sockAdapter.get120Volt();

		System.out.println("v3 volts using Object	Adapter = " + v3.getVolts());
		System.out
				.println("v12 volts using Object	Adapter = " + v12.getVolts());
		System.out.println("v120 volts using Object	Adapter = "
				+ v120.getVolts());
	}
}
