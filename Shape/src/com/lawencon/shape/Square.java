package com.lawencon.shape;

public class Square extends Shape {
	
	public Square(double sisi1, double sisi2) {
		super(sisi1, sisi2);
	}
	
	@Override
	public double areaShapeDouble() {
		return side1 * side2;
	}
	@Override
	public double perimeterShapeDouble() {
		return 4*side1;
	}
}
