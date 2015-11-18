package com.design.structural.composite;

/**
 * Composite pattern should be applied only when the group of objects should
 * behave as the single object.<br />
 * Composite pattern can be used to create a tree like structure.
 * 
 * @author Deepesh
 * 
 */
public class TestCompositePattern {

	public static void main(String[] args) {
		Shape triangle = new Triangle();
		Shape triangle1 = new Triangle();
		Shape circle = new Circle();

		Drawing drawing = new Drawing();
		drawing.add(triangle);
		drawing.add(triangle1);
		drawing.add(circle);

		drawing.draw("RED");

		drawing.clear();

		drawing.add(triangle);
		drawing.add(circle);
		drawing.draw("GREEN");
	}
}
