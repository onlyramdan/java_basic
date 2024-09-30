package com.lawencon.gojek.service;

import com.lawencon.gojek.model.Goride;

public interface GorideService {
	String addOder(Goride goride);
	void getOrder(String driver);
}
