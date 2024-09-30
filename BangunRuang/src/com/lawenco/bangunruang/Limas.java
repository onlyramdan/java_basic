package com.lawenco.bangunruang;

public class Limas extends BangunRuang {

	private double sisi;
	private double tinggi;

	public Limas(double sisi, double tinggi) {
		super();
		this.sisi = sisi;
		this.tinggi = tinggi;
	}

	public double getSisi() {
		return sisi;
	}

	public void setSisi(double sisi) {
		this.sisi = sisi;
	}

	public double getTinggi() {
		return tinggi;
	}

	public void setTinggi(double tinggi) {
		this.tinggi = tinggi;
	}

	@Override
	public double hitungVolume() {
		return (Math.pow(sisi, 2)*tinggi)/3;
	}

	@Override
	public double hitungLuasPermukaan() {
		return (Math.pow(sisi, 2) + 3*(sisi*tinggi)/2);
	}

}
