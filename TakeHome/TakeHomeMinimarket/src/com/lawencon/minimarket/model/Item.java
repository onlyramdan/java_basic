package com.lawencon.minimarket.model;

public class Item {
	private String name;
	private Integer price;
	private Integer stock;
	private Category category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return String.format("""
				Item
				Name: %s,
				Price: Rp %d,
				Stock: %d,
				Category: %s
				""", name, price, stock, category != null ? category.getName() : "No Category");
	}

	public String toStringList() {
		return String.format("""
				%s |Price: Rp. %d |Stock: %d |Category: %s
				""", name, price, stock, category != null ? category.getName() : "No Category");
	}
}