package com.lawencon.asongan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.asongan.model.Cart;
import com.lawencon.asongan.service.CartService;

public class CartImpl implements CartService {
	private List<Cart> cart = new ArrayList<>();

	@Override
	public Cart addCart(Cart cartadd) {
		if(cart.size() == 0) {
			cart.add(cartadd);
		}else {
			boolean find = false;
			for(int i = 0 ; i <cart.size();i++) {
				if(cart.get(i).getNama().equals(cartadd.getNama())) {
					cart.get(i).setJumlah(cart.get(i).getJumlah()+cartadd.getJumlah());
					cart.get(i).setSubTotal(cart.get(i).getSubTotal()+ cartadd.getSubTotal());
					find = true;
					break;
				}
			}
			if (!find) {
				cart.add(cartadd);
			}
		}
		
		return cartadd;
	}

	@Override
	public List<Cart> getCart() {
		return cart;
	}

	@Override
	public void deleteOneCart(int index) {
		cart.remove(index);
	}

	@Override
	public void updateCart(int index, int qty) {
		Integer subtotal = cart.get(index).getSubTotal()/cart.get(index).getJumlah();		
		cart.get(index).setJumlah(qty);
		cart.get(index).setSubTotal(subtotal*qty);
		
	}

	@Override
	public Integer getGrandTotal() {
		Integer grandtotal = 0;
		for(Cart carts : cart) {
			grandtotal += carts.getSubTotal();
		}
		return grandtotal;
	}

}
