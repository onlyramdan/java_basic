package com.lawencon.gojek.model;

public class OrderGofood {
	private String codeTrx;
	private String driver;
	private int qty;
	private int price;

	public OrderGofood(String codeTrx, String driver, int price, int qty ) {
		this.codeTrx = codeTrx;
		this.driver = driver;
		this.price = price;
		this.qty = qty;
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

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
