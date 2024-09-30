package com.lawencon.ojolsantuy.view;

import com.lawencon.ojolsantuy.service.DriverService;
import com.lawencon.ojolsantuy.service.RideService;
import com.lawencon.ojolsantuy.service.SendService;
import com.lawencon.ojolsantuy.service.impl.DriverServiceImpl;
import com.lawencon.ojolsantuy.service.impl.RideServiceImpl;
import com.lawencon.ojolsantuy.service.impl.SendServiceImpl;
import com.lawencon.ojolsantuy.util.ScannerUtil;

public class MainView {

	public void show() {
		System.out.println("===== Ojol Santuy =====");
		System.out.println("1. Ride");
		System.out.println("2. Send");
		System.out.println("3. Food");

		final int option= ScannerUtil.scannerInt("Choose ? ", 1, 3);
		if (option == 1) {
			final RideService rideService = 
					new RideServiceImpl();
			final DriverService driverService = new DriverServiceImpl();
			final RideView rideView = new RideView(rideService,driverService);
			rideView.show();
		}
		else if(option ==2) {
			final SendService sendService = new SendServiceImpl();
			final DriverService driverService = new DriverServiceImpl();
			final SendView sendView = new SendView(sendService,driverService);
			sendView.show();
		}		
		
		show();
	}
	
}
