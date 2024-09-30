package com.lawenco.bangunruang;

public class Bola extends BangunRuang {
	private double radius;

	public Bola(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}


	@Override
	public double hitungVolume() {
		return (4/3)*(Math.PI * Math.pow(radius, 3));
	}

	@Override
	public double hitungLuasPermukaan() {
		return 4*Math.PI*Math.pow(radius, 2);
	}

}
