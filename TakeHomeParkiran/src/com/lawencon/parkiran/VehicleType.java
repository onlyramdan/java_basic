package com.lawencon.parkiran;

public enum VehicleType {
	Car("Car",5000, 100000), Motorcycle("Motorcycle", 1000, 50000);

	private String vihicle;
	private int price;
	private int fine;
	private VehicleType(String vihicle, int price, int fine) {
		this.vihicle = vihicle;
		this.price = price;
		this.fine = fine;
	}
	
	public String getVihicle() {
		return vihicle;
	}
	public void setVihicle(String vihicle) {
		this.vihicle = vihicle;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}
	
}
