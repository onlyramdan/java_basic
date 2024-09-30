package com.lawencon.parkiran;

import java.util.Date;

public class Vihicle {
	private String parkingCode;
    private String numberPlate;
    private String vehicleType;
    private Date checkInTime;
    private Date checkOutTime;
    private int totalPrice;
    
	public Vihicle(String parkingCode, String numberPlate, String vehicleType, Date checkInTime) {
		this.parkingCode = parkingCode;
		this.numberPlate = numberPlate;
		this.vehicleType = vehicleType;
		this.checkInTime = checkInTime;
	}
	
	public Vihicle() {
	}
	
	public String getParkingCode() {
		return parkingCode;
	}
	public void setParkingCode(String parkingCode) {
		this.parkingCode = parkingCode;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Date getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
    
}
