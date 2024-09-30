package com.lawencon.gojek.constant;

public enum Driver {
	DRIVER1("SUPRI",1000 ),DRIVER2("MAMAT",2000),DRIVER3("UCUP",3000);
	String namDriver;
	int price;
	
	private Driver(String namDriver, int price) {
		this.namDriver = namDriver;
		this.price = price;
	}

	public String getNamDriver() {
		return namDriver;
	}

	public void setNamDriver(String namDriver) {
		this.namDriver = namDriver;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
