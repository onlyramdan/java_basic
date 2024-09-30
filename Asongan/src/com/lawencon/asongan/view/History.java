package com.lawencon.asongan.view;

import com.lawencon.asongan.model.Transaksi;
import com.lawencon.asongan.util.ScannerUtil;

public class History {

	public void show() {
		System.out.println("===== History ======");
		int number = 1;
		for (Transaksi trx : MainView.transaksiService.getAll()) {
			System.out.print(number);
			System.out.print("  No Trx:" + trx.getNoTransaksi());
			System.out.println("  |GranTotal:" + trx.getGrandTotal());
			number++;
		}
		
		
		System.out.println("\n\n1. Back");
		
		int option = ScannerUtil.scannerInt("Input Menu: ", 1, 1);
		switch(option) {
		case 1 :
			MainView.show();
			break;
		default:
			System.out.println("Invalid Input");
			MainView.show();
			break;
		}
	}

}
