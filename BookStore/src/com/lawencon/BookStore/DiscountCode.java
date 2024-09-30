package com.lawencon.BookStore;

public enum DiscountCode {
	BERKAH("BERKAH", 0.03),HEBAT("HEBAT", 0.2),BIASA("BIASA", 0.5);
	
	private String code;
	private double discount;
	
	private DiscountCode(String code, double discount) {
		this.code = code;
		this.discount = discount;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
