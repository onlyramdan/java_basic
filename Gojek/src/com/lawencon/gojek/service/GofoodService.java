package com.lawencon.gojek.service;

import com.lawencon.gojek.model.OrderGofood;

public interface GofoodService<T> {
	void addMenu(T gofoodlist);
	void getlist();
	boolean editListQty(int index ,int qty);
	boolean deleteOne(int index);
	boolean deleteAll();
	OrderGofood getCheckout();
	void getOrder(String codeTrx);
	String addOrder();
}
