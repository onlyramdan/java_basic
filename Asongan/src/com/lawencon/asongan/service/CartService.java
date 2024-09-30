package com.lawencon.asongan.service;

import java.util.List;

import com.lawencon.asongan.model.Cart;

public interface CartService {
	Cart addCart(Cart cart);
	List<Cart> getCart();
	void deleteOneCart(int i);
	void updateCart(int i, int itemQty);
	Integer getGrandTotal();
}
