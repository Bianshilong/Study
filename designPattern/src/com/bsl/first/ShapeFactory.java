package com.bsl.first;

public class ShapeFactory {
	
	public Shape getShape(String shapeType) {
		if (shapeType==null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("SSSSSS")) {
			return new Ssssss();
		}else if (shapeType.equalsIgnoreCase("Rectangle")) {
			return new RectAngle();
		}else if (shapeType.equalsIgnoreCase("circle")) {
			return new Circle();
		}else {
			return null;
		}
	}
}
