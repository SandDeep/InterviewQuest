package com.design.creational.builder;


public class TestBuilder {

	public static void main(String[] args) {
		Computer computer = new Computer.ComputerBuilder("500 GB", "2 GB")
				.setBluetoothEnabled(true).build();
		System.out.println(computer);
	}
}
