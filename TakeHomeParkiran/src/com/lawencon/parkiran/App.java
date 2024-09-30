package com.lawencon.parkiran;

import java.util.Date;

public class App {
	private Validate validate = new Validate();
	private ParkingList parking = new ParkingList();
	
	public static void main(String[] args) {
		App app = new App();
		app.startApp();
	}
	
	private void startApp() {
		System.out.println("=================");
		System.out.println("-- Parking Menu --");
		System.out.println("=================");
		
		System.out.println("1. Check-in");
		System.out.println("2. Check-out");
		System.out.println("3. Parking Report");
		System.out.println("4. Exit");
		
		
		
		System.out.print("Input Menu:");
		
		byte option = ScannerUtil.scanByte();
		switch(option) {
		case 1 :
			checkIn();
			break;
		case 2 :
			checkOut();
			break;
		case 3 :
			report();
			break;
		case 4 :
			exit();
			break;
		default:
			System.out.println("Input Not Valid");
			startApp();
			break;
		}
	}
	private void checkIn(){
		System.out.println("=================");
		System.out.println("----Check In-----");
		System.out.println("=================");
		
		int number = 1;
		for (VehicleType vihicles : VehicleType.values()) {
			System.out.println(number + ". " + vihicles.getVihicle());
			number++;
		}
		
		System.out.print("Choose Vihicle Type: ");
		
		byte option = ScannerUtil.scanByte();
		String vihicleType = option == 1 ? VehicleType.Car.name() : VehicleType.Motorcycle.name();
		
		System.out.print("Input Plate Number : ");
		String plateNumber = ScannerUtil.scanString();
		String day = DateUtil.day();
		
		if(!(validate.isValidatePlate(plateNumber))){
			System.out.println("!!! The vehicle cannot be parked !!!");
			startApp();
		}
		
		if(parking.getParkedVehicles().contains(plateNumber+day)){
			System.out.println("!!! The vehicle has been parked !!!");
			startApp();
		}
		Date date = new Date();
		String tiket = new Ticket().generteTicket();
		parking.parkedVehicles.add(plateNumber+day);
		parking.activeTickets.put(tiket, new Vihicle(tiket,plateNumber, vihicleType , date));
		parking.activePlate.put(plateNumber, new Vihicle(tiket,plateNumber, vihicleType , date));
		
		System.out.println("Parking Success !!!");
		System.out.println("Tiket : " + tiket);
		System.out.println("Plate : " + plateNumber);
		System.out.println("Time Checkin : " + DateUtil.formatDate(date));
		startApp();
		
	}
	
	private void checkOut(){
		System.out.println("=================");
		System.out.println("--- Check Out ---");
		System.out.println("=================");
		
		System.out.println("Input Ticket Number ");
		System.out.println("If Forget Ticket Number Input Plate Number");
		System.out.println("With vihicles fine: 1. Car Rp. 100.000  | 2. MotorCycle Rp. 50.000");
		
		System.out.println("1. Ticket Number");
		System.out.println("2. Plate Number");
		System.out.println("3. Back");
		
		System.out.print("\nInput : ");
		byte option = ScannerUtil.scanByte();
		switch (option) {
		case 1: 
			checkoutTicket();
			break;
		case 2:
			checkoutPlate();
			break;
		case 3 :
			startApp();
			break;
		default:
			System.out.println("Input Not Valid");
			checkOut();
			break;
		}
	
		
	}
	
	private void checkoutTicket(){
		
		System.out.print("Input Ticket Number: ");
		String strgTiket = ScannerUtil.scanString();
		
		if(!parking.activeTickets.containsKey(strgTiket)) {
			System.out.println("Please, Checkin First!");
			checkOut();
		}
		
		Vihicle vihicleTiket = parking.activeTickets.get(strgTiket);
		
		Date dateCheckout = new Date();
		long longTimePakring = dateCheckout.getTime() - vihicleTiket.getCheckInTime().getTime();
		long hoursParking = (longTimePakring / (1000*60*60)) + 1;
		int priceType = vihicleTiket.getVehicleType() == VehicleType.Car.name() ? VehicleType.Car.getPrice() : VehicleType.Motorcycle.getPrice();  
		int price = (int ) hoursParking * priceType;
		
		vihicleTiket.setCheckOutTime(dateCheckout);
		vihicleTiket.setTotalPrice(price);
		parking.parkingList.add(vihicleTiket);
		parking.activeTickets.remove(strgTiket);
		parking.activePlate.remove(vihicleTiket.getNumberPlate());
		
		System.out.println("Successfull Checkout !!!");
		System.out.println("Total Harga : Rp. " + price );
		startApp();
	}
	
	private void checkoutPlate() {
		System.out.print("Input Plate Number: ");
		String strgPlate = ScannerUtil.scanString();
		
		if(!(validate.isValidatePlate(strgPlate))){
			System.out.println("!!! Plate Number Not Valid !!!");
			checkoutPlate();
		}
		
		if(!parking.activePlate.containsKey(strgPlate)) {
			System.out.println("Please, Checkin First!");
			checkOut();
		}
		
		Vihicle vihicleTiket  = parking.activePlate.get(strgPlate);
		Date dateCheckout = new Date();
		
		long longTimePakring = dateCheckout.getTime() - vihicleTiket.getCheckInTime().getTime();
		long hoursParking = (longTimePakring / (1000*60*60)) + 1;
		int priceType = vihicleTiket.getVehicleType() == VehicleType.Car.name() ? VehicleType.Car.getPrice() : VehicleType.Motorcycle.getPrice(); 
		int priceFine = vihicleTiket.getVehicleType() == VehicleType.Car.name() ? VehicleType.Car.getFine() : VehicleType.Motorcycle.getFine();
		int price = (int ) hoursParking * priceType + priceFine;
		
		vihicleTiket.setCheckOutTime(dateCheckout);
		vihicleTiket.setTotalPrice(price);
		parking.parkingList.add(vihicleTiket);
		parking.activeTickets.remove(vihicleTiket.getParkingCode());
		parking.activePlate.remove(strgPlate);
		
		System.out.println("Successfull Checkout !!!");
		System.out.println("Total Price : Rp. " + price );
		startApp();
	}
	
	private void report(){
		System.out.println("=================");
		System.out.println("---- Report ----");
		System.out.println("=================");
		
		System.out.println("1. Check-in");
		System.out.println("2. Check-out");
		System.out.println("3. Back");
		
		System.out.print("Input :");
		int option = ScannerUtil.scanByte();
		switch(option) {
		case 1:
			reportCheckin();
			break;
		case 2:
			reportCheckout();
			break;
		case 3 :
			startApp();
			break;
		default :
			System.out.println("Input Not Valid");
			report();
			break;
		}
		
	}
	
	private void reportCheckin() {
		System.out.println("=================");
		System.out.println("-- List Checkin --");
		System.out.println("=================");
	    System.out.println("-----------------------------------------------------------------------------------------------");
	    if (parking.activeTickets.size() == 0) {
	    	System.out.println("No Vihicle Checkout!!!");
	    }
	    
	    int number = 1;
	    for (Vihicle checkin : parking.activeTickets.values()) {
	    	System.out.print(number + ". ");
	        System.out.print("Ticket: " + checkin.getParkingCode());
	        System.out.print(" | Plate : " + checkin.getNumberPlate());
	        System.out.print(" | Type : " + checkin.getVehicleType());
	        System.out.println(" | Check-in : " + DateUtil.formatDate(checkin.getCheckInTime()));
	        number++;
		       
	    }
	    System.out.println("-----------------------------------------------------------------------------------------------");
	    System.out.println("1. Back | 2. Main Menu ");
	    System.out.print("Input :");
	    int option = ScannerUtil.scanByte();
	    
	    switch(option) {
	    case 1:
	    	report();
	    	break;
	    case 2:
	    	startApp();
	    	break;
	    default :
	    	System.out.println("Input Not Valid");
	    	reportCheckin();
	    	break;
	    }
	}
	
	private void reportCheckout(){
		System.out.println("=================");
		System.out.println("-- List Checout --");
		System.out.println("=================");
	    System.out.println("---------------------------------------------------------------------------------------------------------------------");
	    
	    if (parking.parkingList.size() == 0) {
	    	System.out.println("No Vihicle Check out!!!");
	    }
	    
	    int number = 1;
	    for (Vihicle checkouts : parking.getParkingList()) {
	        System.out.print(number + ". ");
	        System.out.print("Ticket: " + checkouts.getParkingCode());
	        System.out.print(" | Plate: " + checkouts.getNumberPlate());
	        System.out.print(" | Type : " + checkouts.getVehicleType());
	        System.out.print(" | Check-in : " + DateUtil.formatDate(checkouts.getCheckInTime()));
	        System.out.print(" | Check-out : " + DateUtil.formatDate(checkouts.getCheckOutTime()));
	        System.out.println(" | Price: Rp. " + checkouts.getTotalPrice());
	        number++;
	    }
	    System.out.println("---------------------------------------------------------------------------------------------------------------------");
	    
	    System.out.println("1. Back | 2. Main Menu ");
	    System.out.print("Input :");
	    int option = ScannerUtil.scanByte();
	    
	    switch(option) {
	    case 1:
	    	report();
	    	break;
	    case 2:
	    	startApp();
	    	break;
	    default :
	    	System.out.println("Input Not Valid");
	    	reportCheckout();
	    	break;
	    }
	}
	
	private void exit() {
		System.out.println("=================");
		System.out.println("------Exit-------");
		System.out.println("=================");
		
		System.out.println("Thank You! :)");
		System.exit(0);
	}

}