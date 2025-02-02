package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.CartDetail;

public interface CartService {
	CartDetail addCart(CartDetail cart);
	List<CartDetail> getAll();
	void deleteOneCart(int i);
	void updateCart(int i, int itemQty);
	Integer getGrandTotal();
	void deleteAll();
}
