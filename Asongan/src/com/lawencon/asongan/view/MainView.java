package com.lawencon.asongan.view;

import com.lawencon.asongan.service.impl.TransaksiImpl;
import com.lawencon.asongan.service.TransaksiService;
import com.lawencon.asongan.util.ScannerUtil;

public class MainView {
	public static TransaksiService transaksiService = new TransaksiImpl();
	
	public static void show() {
		System.out.println("===== Asongan =====");
		System.out.println("1. List Barang");
		System.out.println("2. History");
		System.out.println("3. Exit");

		int option = ScannerUtil.scannerInt("Input Menu:", 1, 3);
		switch (option) {
		case 1:
			final ListBarang listBarangView = new ListBarang();
			listBarangView.show();
			break;
		case 2:
			final History historyView = new History();
			historyView.show();
			break;
		case 3:
			System.out.println("!!!Exit!!!");
			System.exit(0);
			break;
		default:
			System.out.println();
			show();
			break;
		}
	}
}
