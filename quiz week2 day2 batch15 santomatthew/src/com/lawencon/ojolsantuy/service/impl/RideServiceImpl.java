package com.lawencon.ojolsantuy.service.impl;

import com.lawencon.ojolsantuy.service.RideService;

public class RideServiceImpl implements RideService {
private static final int DEFAULT_PRICE = 15000;


	@Override
	public double calculatePrice(String from, String to) {
		final double result = DEFAULT_PRICE + (from.length() * to.length());
		return result;
	}
}
