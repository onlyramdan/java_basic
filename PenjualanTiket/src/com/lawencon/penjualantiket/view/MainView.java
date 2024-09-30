package com.lawencon.penjualantiket.view;

import com.lawencon.penjualantiket.model.ListOder;
import com.lawencon.penjualantiket.service.BusService;
import com.lawencon.penjualantiket.service.impl.BusImpl;
import com.lawencon.penjualantiket.utils.ScannerUtil;

public class MainView {
	static ListOder orderList = new ListOder();
	final static BusService busService = new BusImpl(orderList);

	public static void show() {
		System.out.println("===== Ticketing =====");
		System.out.println("1. Jadwal Keberangkatan");
		System.out.println("2. History");
		System.out.println("3. Exit");

		System.out.print("\nInput Menu: ");
		byte option = ScannerUtil.scanByte();
		switch (option) {
		case 1:
			final JadwalView jadwalView = new JadwalView();
			jadwalView.show(busService);
			break;
		case 2:
			final HistoryView historyView = new HistoryView();
			historyView.show(busService, orderList);
			break;
		case 3:
			System.out.println("Exit");
			System.exit(0);
			break;
		}
	}

}
