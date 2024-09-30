package com.lawencon.penjualantiket.model;

import java.util.ArrayList;
import java.util.List;

public class ListOder {
	
	private List<Bus> bus = new ArrayList<>();
	private List<Order> orderBus = new ArrayList<>();
	
	public List<Bus> getBus() {
		return bus;
	}
	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}
	public List<Order> getOrderBus() {
		return orderBus;
	}
	public void setOrderBus(List<Order> orderBus) {
		this.orderBus = orderBus;
	}
	
	
}
