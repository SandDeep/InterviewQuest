package com.design.structural.bridge;

/**
 * Bridge design pattern can be used when both abstraction and implementation
 * can have different hierarchies independently and we want to hide the
 * implementation from the client application.
 * 
 * @author Deepesh
 * 
 */
public class BridgePatternTest {

	public static void main(String[] args) {
		Shape triangle = new Triangle(new RedColor());
		triangle.applyColor();

		Shape pentagon = new Pentagon(new GreenColor());
		pentagon.applyColor();
	}
}
