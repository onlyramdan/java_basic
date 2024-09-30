package com.lawencon.BookStore;

public class Item {
	
	private String itemName;
	private int itemQty;
	private int itemTotalPrice;
	
	public Item(String itemName, int itemQty, int itemTotalPrice) {
		this.itemName = itemName;
		this.itemQty = itemQty;
		this.itemTotalPrice = itemTotalPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	
	public int getItemTotalPrice() {
		return itemTotalPrice;
	}

	public void setItemTotalPrice(int itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}
	

}
