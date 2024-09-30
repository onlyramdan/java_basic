package com.lawencon.penjualantiket.service;

import java.util.List;

import com.lawencon.penjualantiket.model.Bus;
import com.lawencon.penjualantiket.model.Order;

public interface BusService {
	void getSeat(int numberBus);
	List<Bus> getBusList();
	void orderBus(int seat, int numberBus);
	void checkoutBus(Order order);
	int getPrice(int numberBus);
	void getCheckout();
}
