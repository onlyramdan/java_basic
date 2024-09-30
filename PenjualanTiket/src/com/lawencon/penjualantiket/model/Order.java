package com.lawencon.penjualantiket.model;

import java.time.LocalDate;

public class Order {
	private String noTrx;
	private LocalDate Date;
	private Passanger passanger;
	private int price;
	private int seatNumber;
	private int numberKendaraan;
	public String getNoTrx() {
		return noTrx;
	}
	public void setNoTrx(String noTrx) {
		this.noTrx = noTrx;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		Date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumberKendaraan() {
		return numberKendaraan;
	}
	public void setNumberKendaraan(int numberKendaraan) {
		this.numberKendaraan = numberKendaraan;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Passanger getPassanger() {
		return passanger;
	}
	public void setPassanger(Passanger passanger) {
		this.passanger = passanger;
	}

	
	
	
}
