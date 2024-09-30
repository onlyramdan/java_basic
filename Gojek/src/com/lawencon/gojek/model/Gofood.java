package com.lawencon.gojek.model;

public class Gofood extends Goride {
	
	private String restoran;
	private String  menu;
	private int priceMenu;
	private int qty;
	
	public Gofood(String addressPosision, String addressDestination, int distance, String restoran, String menu,
			int priceMenu, int qty) {
		super(addressPosision, addressDestination, distance);
		this.restoran = restoran;
		this.menu = menu;
		this.priceMenu = priceMenu;
		this.qty = qty;
	}
	
	
	public String getRestoran() {
		return restoran;
	}

	public void setRestoran(String restoran) {
		this.restoran = restoran;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPriceMenu() {
		return priceMenu;
	}

	public void setPriceMenu(int priceMenu) {
		this.priceMenu = priceMenu;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
