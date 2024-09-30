package com.lawencon.ojolsantuy.service.impl;

import com.lawencon.ojolsantuy.service.SendService;

public class SendServiceImpl implements SendService{

	@Override
	public double calculatePrice(String from, String to, double weight, int price) {
		final double result = (price*weight)+ (from.length()+to.length());
		return result;
	}
}
