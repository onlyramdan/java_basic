package com.lawencon.penjualantiket.view;

import com.lawencon.penjualantiket.model.ListOder;
import com.lawencon.penjualantiket.model.Order;
import com.lawencon.penjualantiket.service.BusService;
import com.lawencon.penjualantiket.utils.ScannerUtil;

public class HistoryView {
	public void show(BusService busService, ListOder orderList) {
		int number = 1;
		for(Order orderBus : orderList.getOrderBus()) {
			System.out.print(number +".");
			System.out.print("No Trx : " + orderBus.getNoTrx());
			System.out.print("No ktp : " + orderBus.getPassanger().getNomerKtp());
			System.out.print("Waktu: " + orderBus.getDate().toString());
			System.out.println("Rp. : " + orderBus.getPrice());
		}
		
		System.out.println("1.Back");
		System.out.print("Input :");
		int option = ScannerUtil.scanByte();
		switch(option){
		case 1:
			MainView.show();
			break;
		default:
			break;
		}
		
	}
}
