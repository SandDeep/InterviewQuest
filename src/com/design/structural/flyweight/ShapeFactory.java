package com.design.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory will be used by client programs to instantiate the Object,
 * so we need to keep a map of Objects in the factory that should not be
 * accessible by client application.
 * 
 * @author Deepesh
 * 
 */
public class ShapeFactory {

	private static final Map<ShapeType, Shape> shapes = new HashMap<ShapeFactory.ShapeType, Shape>();

	public static Shape getShape(ShapeType type) {
		Shape shapeImpl = shapes.get(type);

		if (shapeImpl == null) {

			if (type.equals(ShapeType.OVAL_FILL)) {
				shapeImpl = new Oval(true);
			} else if (type.equals(ShapeType.OVAL_NOFILL)) {
				shapeImpl = new Oval(false);
			} else if (type.equals(ShapeType.LINE)) {
				shapeImpl = new Line();
			}
			shapes.put(type, shapeImpl);
		}
		return shapeImpl;
	}

	public static enum ShapeType {
		OVAL_FILL, OVAL_NOFILL, LINE;
	}
}
