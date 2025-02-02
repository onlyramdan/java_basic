package com.lawencon.minimarket.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.CartDetail;
import com.lawencon.minimarket.service.CartService;

public class CartServiceImpl implements CartService {
	private List<CartDetail> cartList = new ArrayList<>();

	@Override
	public CartDetail addCart(CartDetail cart) {
		for (int i = 0; i < cartList.size(); i++) {
			if (cartList.get(i).getName().equals(cart.getName())) {
				int totalQty = cartList.get(i).getQty() + cart.getQty();
				int price = cartList.get(i).getSubtotal() / cartList.get(i).getQty();
				cartList.get(i).setQty(totalQty);
				cartList.get(i).setSubtotal(price * totalQty);
				return cart;
			}
		}
		cartList.add(cart);
		return cart;
	}

	@Override
	public List<CartDetail> getAll() {
		if (cartList.size() == 0) {
			System.out.println("Belum ada Item di Keranjang");
		}
		return cartList;
	}

	@Override
	public void deleteOneCart(int i) {
		if (i >= 0 && i < cartList.size()) {
			cartList.remove(i);
		} else {
			System.out.println("Index di luar jangkauan");
		}

	}

	@Override
	public void updateCart(int i, int itemQty) {
		if (i >= 0 && i < cartList.size()) {
			CartDetail cartDetail = cartList.get(i);
			int price = cartDetail.getSubtotal() / cartDetail.getQty();
			cartDetail.setQty(itemQty);
			cartDetail.setSubtotal(price * itemQty);
		} else {
			System.out.println("Index di luar jangkauan");
		}
	}

	@Override
	public Integer getGrandTotal() {
		int grandTotal = 0;
	    for (CartDetail cartDetail : cartList) {
	        grandTotal += cartDetail.getSubtotal();
	    }
	    return grandTotal;
	}

	@Override
	public void deleteAll() {
		cartList.clear();
	}

}
