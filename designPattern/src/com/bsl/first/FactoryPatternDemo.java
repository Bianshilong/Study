package com.bsl.first;

public class FactoryPatternDemo {
	
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		//获取对象，调用方法
		Shape shape1 = shapeFactory.getShape("circle");
		shape1.draw();
		Shape shape2 = shapeFactory.getShape("ssssss");
		shape2.draw();
		Shape shape3 = shapeFactory.getShape("rectangle");
		shape3.draw();
	}
}
