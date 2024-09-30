package com.lawencon.asongan.model;

import java.util.ArrayList;
import java.util.List;

public class ListTransaksi {
	private List<Cart> cart = new ArrayList<>();
	private List<Transaksi> transaksi = new ArrayList<>();
	
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public List<Transaksi> getTransaksi() {
		return transaksi;
	}
	public void setTransaksi(List<Transaksi> transaksi) {
		this.transaksi = transaksi;
	}
	

}
