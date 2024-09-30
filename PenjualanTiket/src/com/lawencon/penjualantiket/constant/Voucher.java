package com.lawencon.penjualantiket.constant;

public enum Voucher {
	BISA(0.03), HAYU(0.5);
	
	private double diskon;
	

	private Voucher(double d) {
		this.diskon = d;
	}

	public double getDiskon() {
		return diskon;
	}

	public void setDiskon(double diskon) {
		this.diskon = diskon;
	}
	
	
	
}
