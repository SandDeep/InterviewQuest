package com.design.structural.composite;

/**
 * Base Component : defines the common methods for leaf and composites, we can
 * create a class Shape with a method draw(String fillColor) to draw the shape
 * with given color.
 * 
 * @author Deepesh
 * 
 */
public interface Shape {

	public void draw(String fillColor);
}
