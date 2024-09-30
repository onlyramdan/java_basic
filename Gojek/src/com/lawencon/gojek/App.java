package com.lawencon.gojek;

import java.util.Random;

import com.lawencon.gojek.constant.Menu;
import com.lawencon.gojek.constant.Restoran;
import com.lawencon.gojek.model.Gofood;
import com.lawencon.gojek.model.Goride;
import com.lawencon.gojek.model.Gosend;
import com.lawencon.gojek.model.OrderList;
import com.lawencon.gojek.service.GofoodService;
import com.lawencon.gojek.service.OrderService;
import com.lawencon.gojek.service.impl.GofoodImpl;
import com.lawencon.gojek.service.impl.GorideImpl;
import com.lawencon.gojek.service.impl.GosendImpl;
import com.lawencon.gojek.util.ScannerUtil;

public class App {
	OrderList sharedOrderList = new OrderList();
	private OrderService<Goride> gorideService = new GorideImpl(sharedOrderList);
	private OrderService<Gosend> gosendService = new GosendImpl(sharedOrderList);
	private GofoodService<Gofood> gofoodList = new GofoodImpl(sharedOrderList);

	public static void main(String[] args) {
		App app = new App();
		app.startApp();

	}

	private void startApp() {
		System.out.println("=== Menu ===");
		System.out.println("1. Goride");
		System.out.println("2. Gosend");
		System.out.println("3. Gofood");
		System.out.println("4. History");
		System.out.println("5. Exit");

		System.out.print("\nInput :");
		int option = ScannerUtil.scanByte();
		switch (option) {
		case 1:
			goride();
			break;
		case 2:
			gosend();
			break;
		case 3:
			gofood();
			break;
		case 4:
			history();
			break;
		case 5:
			exit();
			break;
		default:
			System.out.println("Input Not Valid");
			startApp();
			break;
		}
	}

	private void history() {
		System.out.println("-===== History =====");

	}

	private void gofood() {
		System.out.println("=== Gofood ===");

		gofoodList.getlist();

		System.out.println("1. List Restoran");
		System.out.println("2. Edit Qty");
		System.out.println("3. Delete menu");
		System.out.println("4. cancel");
		System.out.println("5. Check Out");
		System.out.print("Input: ");
		byte option = ScannerUtil.scanByte();
		switch (option) {
		case 1:
			listMenu();
			break;
		case 2:
			editGoofod();
			break;
		case 3:
			deleteListGofood();
			break;
		case 4:
			cancelGofood();
			break;
		case 5:
			checkoutGofood();
			break;
		case 6:
			break;
		default:
			System.out.println("Input Not Valid!");
			break;
		}
	}

	private void editGoofod() {
		System.out.println("====Update Menu====");
		gofoodList.getlist();

		System.out.print("\n\nInput Number List Menu:");
		int index = ScannerUtil.scanByte() - 1;
		System.out.print("Input Qty : ");
		int qty = ScannerUtil.scanByte();

		boolean hapus = gofoodList.editListQty(index, qty);
		if (hapus) {
			gofood();
		} else {
			System.out.println("Failed Update!");
			gofood();
		}

	}

	private void deleteListGofood() {
		System.out.println("====Delete Menu====");
		gofoodList.getlist();

		System.out.print("\n\nInput Number List Menu:");
		int index = ScannerUtil.scanByte() - 1;
		boolean hapus = gofoodList.deleteOne(index);
		if (hapus) {
			gofood();
		} else {
			System.out.println("Failed Delete!");
			gofood();
		}
	}

	private void cancelGofood() {
		boolean hapus = gofoodList.deleteAll();
		if (hapus) {
			gofood();
		} else {
			System.out.println("Failed Cancel!");
			gofood();
		}

	}

	private void listMenu() {
		System.out.println("===== List Restoran =====");
		int number = 1;
		for (Restoran resto : Restoran.values()) {
			System.out.println(number + "." + resto);
			for (int i = 0; i < resto.getMenuList().size(); i++) {
				System.out.println("   [" + (i + 1) + ".]" + resto.getMenuList().get(i));
			}
			number++;
		}

		System.out.print("Input Number Restoran :");
		int restoranInput = ScannerUtil.scanByte();
		System.out.print("Input Number Menu :");
		int menuInput = ScannerUtil.scanByte();
		System.out.print("Input Qty :");
		int qtyInput = ScannerUtil.scanByte();
		Restoran[] restolist = Restoran.values();
		String resto = restolist[restoranInput - 1].name();
		Menu menu = restolist[restoranInput - 1].getMenuList().get(menuInput - 1);
		Gofood gofood = new Gofood(resto, "", 0, resto, menu.getName(), menu.getPrice() * qtyInput, qtyInput);
		try {
			gofoodList.addMenu(gofood);
			System.out.println("Successfull add Menu");
			System.out.println("1. Add Menu Again ?");
			System.out.println("2. No");
			int option = ScannerUtil.scanByte();
			switch (option) {
			case 1:
				listMenu();
				break;
			case 2:
				gofood();
				break;
			default:
				System.out.println("Input Not Valid");
				break;
			}
		} catch (Exception e) {
			System.out.println("Failed to add menu");
			listMenu();
		}

	}

	private void checkoutGofood() {
		String driver = gofoodList.addOrder();
		gofoodList.getOrder(driver);
		startApp();
	}

	private void goride() {
		System.out.println("=== GoRide ===");
		System.out.print("Input Posision :");
		String posision = ScannerUtil.scanString();
		System.out.print("Input Destinaton :");
		String destination = ScannerUtil.scanString();
		int distance = new Random().nextInt(10) + 1;
		Goride gorideAlamat = new Goride(posision, destination, distance);
		String driver = gorideService.addOrder(gorideAlamat);
		if (driver.equals("Not Found Driver Available")) {
			System.out.println(driver);
			startApp();
		} else {
			gorideService.getOrder(driver);
			startApp();
		}

	}

	private void gosend() {
		System.out.println("=== GoSend ===");
		System.out.print("Input Posision :");
		String posision = ScannerUtil.scanString();
		System.out.print("Input Destinaton :");
		String destination = ScannerUtil.scanString();
		System.out.print("Input receiver :");
		String reciever = ScannerUtil.scanString();
		System.out.print("Input No Hp :");
		String hp = ScannerUtil.scanString();
		System.out.print("Input name Item:");
		String item = ScannerUtil.scanString();
		System.out.print("Input Type :");
		String type = ScannerUtil.scanString();
		System.out.print("Input Weight :");
		int wight = ScannerUtil.scanByte();
		int distance = new Random().nextInt(10) + 1;
		Gosend gosend = new Gosend(posision, destination, distance, reciever, hp, item, type, wight);
		String driver = gosendService.addOrder(gosend);
		if (driver.equals("Not Found Driver Available")) {
			System.out.println(driver);
			startApp();
		} else {
			gosendService.getOrder(driver);
			startApp();
		}

	}

	private void exit() {
		System.out.println("===== Exit =====");
		System.exit(0);
	}

}
