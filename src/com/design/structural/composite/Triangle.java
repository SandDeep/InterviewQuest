package com.design.structural.composite;

/**
 * Leaf Objects : Leaf implements base component and these are the building
 * block for the composite. We can create multiple leaf objects such as
 * Triangle, Circle etc.
 * 
 * @author Deepesh
 * 
 */
public class Triangle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Triangle with color " + fillColor);
	}

}
