package com.lawencon.ojolsantuy.constant;

public enum ItemType {

	ELEKTRONIK("Elektronik", 10000), FARMASI("Farmasi", 15000), APPAREL("Apparel", 12000), FOOD("Food", 20000),
	KOSMETIK("Kosmetik", 25000);

	public final String name;
	public final int price;

	private ItemType(String name, int price) {
		this.name = name;
		this.price = price;
	}

}
