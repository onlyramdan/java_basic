package com.lawencon.shape;

public class Triangle extends Shape {
	private double tinggi;
	public Triangle(double sisi1, double tinggi) {
		super(sisi1, sisi1);
		this.tinggi = tinggi;
	}
	
	@Override
	public double areaShapeDouble(){
		return (side1 * tinggi)/2;
	}
	
	@Override
	public double perimeterShapeDouble() {
		return 3*side1;
	}

}
