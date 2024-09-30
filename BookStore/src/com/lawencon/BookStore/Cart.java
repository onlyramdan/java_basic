package com.lawencon.BookStore;

import java.util.List;
import java.util.ArrayList;

public class Cart {
	private final List<Item> cart = new ArrayList<>();
	
	public List<Item> getCart() {
		return cart;
	}
	
}
