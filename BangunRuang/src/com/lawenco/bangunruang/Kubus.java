package com.lawenco.bangunruang;

public class Kubus extends BangunRuang {

	private double sisi;

	public Kubus(double sisi) {
		this.sisi = sisi;
	}

	public double getSisi() {
		return sisi;
	}

	public void setSisi(double sisi) {
		this.sisi = sisi;
	}

	@Override
	public double hitungVolume() {
		return Math.pow(sisi, 3);
	}

	@Override
	public double hitungLuasPermukaan() {
		return 6 * Math.pow(sisi, 2);
	}

}
