package com.lawencon.gojek.model;

public class Goride {
	private String addressPosision;
	private String addressDestination;
	private int distance;

	public Goride(String addressPosision, String addressDestination, int distance) {
		this.addressPosision = addressPosision;
		this.addressDestination = addressDestination;
		this.distance = distance;
	}
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public String getAddressPosision() {
		return addressPosision;
	}

	public void setAddressPosision(String addressPosision) {
		this.addressPosision = addressPosision;
	}

	public String getAddressDestination() {
		return addressDestination;
	}

	public void setAddressDestination(String addressDestination) {
		this.addressDestination = addressDestination;
	}

}
