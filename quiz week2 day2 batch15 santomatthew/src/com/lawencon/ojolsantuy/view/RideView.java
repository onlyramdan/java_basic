package com.lawencon.ojolsantuy.view;


import com.lawencon.ojolsantuy.model.Driver;
import com.lawencon.ojolsantuy.service.DriverService;
import com.lawencon.ojolsantuy.service.RideService;
import com.lawencon.ojolsantuy.util.ScannerUtil;

public class RideView {

	private final RideService rideService;
	private final DriverService driverService;
	
	public RideView(RideService rideService,DriverService driverService) {
		this.rideService = rideService;
		this.driverService = driverService;
	}

	void show() {
		System.out.println("===== Ride Santuy =====");

		final String optionFrom = ScannerUtil.scannerStr("From : ");
		final String optionTo = ScannerUtil.scannerStr("To :");
		
		final double totalPrice = rideService.calculatePrice(optionFrom, optionTo);
		final Driver driver = driverService.findDriver();
		
		System.out.println("===== Details =====");
		System.out.println("=== Driver ===");
		System.out.println("Nama : "+driver.getFullName());
		System.out.println("Plat No : "+driver.getPlatNo());
		System.out.println("Hp : "+driver.getHp());
		
		System.out.println("=== Price ===");
		System.out.println("Rp."+totalPrice);
		
		System.out.println("=== Location ===");
		System.out.println("From : "+optionFrom);
		System.out.println("To : "+optionTo);
	}
	
}
