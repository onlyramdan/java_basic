package com.lawencon.gojek.service;

public interface OrderService<T> {
	String addOrder(T data);
	void getOrder(String codeTrx);
}
