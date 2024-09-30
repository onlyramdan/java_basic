package com.lawencon.gojek.service;

import com.lawencon.gojek.model.Gosend;

public interface GosendService {
	String addOrder(Gosend gosend);
	void getOrder(String driver);

}
