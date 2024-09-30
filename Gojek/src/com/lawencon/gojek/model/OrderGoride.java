package com.lawencon.gojek.model;

public class OrderGoride {
	private String codeTrx;
	private String driver;
	private Goride goride ;
	private int price;
	
	public OrderGoride(String codeTrx, String driver, Goride goride, int price) {
		this.codeTrx = codeTrx;
		this.driver = driver;
		this.goride = goride;
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
	
	public Goride getGoride(){
		return goride;
	}
	
	public int getPrice() {
		return price;
	}
}
