package com.lawencon.gojek.model;

public class OrderGosend {
	private String codeTrx;
	private String driver;
	private Gosend gosend;
	private int price;

	public OrderGosend(String codeTrx, String driver, Gosend gosend, int price) {
		this.codeTrx = codeTrx;
		this.driver = driver;
		this.gosend = gosend;
		this.price = price;
	}

	
	public String getCodeTrx() {
		return codeTrx;
	}

	public void setCodeTrx(String codeTrx) {
		this.codeTrx = codeTrx;
	}
	
	public String getDriver() {
		return driver;
	}

	public Gosend getGosend() {
		return gosend;
	}

	public int getPrice() {
		return price;
	}
}
