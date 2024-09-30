package com.lawencon.BookStore;

public class ItemHistory {
	private String invoiceCode;
	private String time;
	private double total_price;
	
	public ItemHistory(String invoiceCode, String time, double total_price) {
		this.invoiceCode = invoiceCode;
		this.time = time;
		this.total_price = total_price;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
	
}