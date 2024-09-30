package com.lawenco.bangunruang;

public class Balok extends BangunRuang {
	private double panjang;
	private double lebar;
	private double tinggi;

	public Balok(double panjang, double lebar, double tinggi) {
		super();
		this.panjang = panjang;
		this.lebar = lebar;
		this.tinggi = tinggi;
	}

	public double getPanjang() {
		return panjang;
	}

	public void setPanjang(double panjang) {
		this.panjang = panjang;
	}

	public double getLebar() {
		return lebar;
	}

	public void setLebar(double lebar) {
		this.lebar = lebar;
	}

	public double getTinggi() {
		return tinggi;
	}

	public void setTinggi(double tinggi) {
		this.tinggi = tinggi;
	}

	@Override
	public double hitungVolume() {
		return panjang*lebar*tinggi;
	}

	@Override
	public double hitungLuasPermukaan() {
		return 2*(panjang*lebar + panjang*tinggi + lebar*tinggi);
	}

}
