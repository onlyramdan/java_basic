package com.lawencon.shape;

public class Rectangle extends Shape {

	public Rectangle(double sisi1, double sisi2) {
		super(sisi1, sisi2);
	}
	
	@Override
	public double areaShapeDouble() {
		return side1*side2;
	}
	
	@Override
	public double perimeterShapeDouble(){
		return 2*(side1+side2);
	}

}
