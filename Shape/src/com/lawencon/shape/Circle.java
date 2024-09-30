package com.lawencon.shape;

public class Circle extends Shape {
	
	public Circle(double radius) {
		super(radius, radius);
	}

	@Override
	public double areaShapeDouble(){
		return 3.14*side1*side1;	
	}
	
	@Override
	public double perimeterShapeDouble(){
		return 2*3.14*side1;
	}

}
