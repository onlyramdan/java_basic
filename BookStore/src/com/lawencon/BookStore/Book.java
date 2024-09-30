package com.lawencon.BookStore;

public enum Book {
	JAVA("java",10000),KOTLIN("kotlin",11000),GOLANG("golang",12000),PYTHON("python",13000);
	
	private String name;
	private int price;
	
	private Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
	
}
