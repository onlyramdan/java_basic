package com.lawencon.penjualantiket.view;

import com.lawencon.penjualantiket.constant.Voucher;
import com.lawencon.penjualantiket.model.Bus;
import com.lawencon.penjualantiket.model.Order;
import com.lawencon.penjualantiket.model.Passanger;
import com.lawencon.penjualantiket.service.BusService;
import com.lawencon.penjualantiket.utils.ScannerUtil;

public class JadwalView {
	void show(BusService busService) {
		String jenisTiketMenu = """
				========= Pilih kendaraan ==========
				1. Bus
				2. Train
				3. Plane


				Input Menu:
				""";
		System.out.print(jenisTiketMenu);
		int option = ScannerUtil.scanByte();
		switch (option) {
		case 1:
			bus(busService);
			break;
		case 2:
			train();
			break;
		case 3:
			plane();
			break;
		default:
			System.out.println("Invalid Input!");
			show(busService);
			break;
		}
	}

	private void bus(BusService busService) {
		System.out.println("====== List Bus =======");
		int number = 1;
		for (Bus bus : busService.getBusList()) {
			System.out.print(number + ". ");
			System.out.print(bus.getName());
			System.out.print(" | from : " + bus.getFrom());
			System.out.print(" | ke : " + bus.getTo());
			System.out.print(" | Tanggal Keberangkatan : " + bus.getDate().toString());
			System.out.println(" | harga Rp. " + bus.getPrice());
			number++;
		}
		System.out.print("\n Input Number Bus : ");
		int numberBus = ScannerUtil.scanByte();

		System.out.println("========Pilih Kursi=========");
		busService.getSeat(numberBus);

		System.out.print("\n Input Number Kursi: ");
		int numberKursi = ScannerUtil.scanByte();
		busService.orderBus(numberKursi, numberBus);

		String memesanLagi = """
				Apakah Ingin Memesan Lagi?
				1. Ya
				2. No

				Input Menu:
				""";

		System.out.print(memesanLagi);
		int option = ScannerUtil.scanByte();
		switch (option) {
		case 1:
			bus(busService);
		case 2:
			checkoutBus(busService, numberBus, numberKursi);
		default:
			System.out.println("Invalid Input Gagal");
			bus(busService);
			break;
		}

	}

	private void checkoutBus(BusService busService, int numberBus, int numberKursi) {
		System.out.println("==== Checkout ====");
		System.out.print("name : ");
		String name = ScannerUtil.scanString();
		System.out.print("nomer Ktp : ");
		String noKtp = ScannerUtil.scanString();

		for (Voucher diskon : Voucher.values()) {
			System.out.println(diskon);
		}
		System.out.print("Input Kode Diskon: ");
		String codeDiskon = ScannerUtil.scanString();
		int price = busService.getPrice(numberBus);
		for (Voucher diskon : Voucher.values()) {
			if (diskon.toString().equals(codeDiskon)) {
				price = (int) (busService.getPrice(numberBus) * diskon.getDiskon());
			}
		}
		Order order = new Order();
		Passanger passgr = new Passanger();

		order.setNumberKendaraan(numberBus);
		order.setSeatNumber(numberKursi);
		order.setPrice(price);
		passgr.setName(name);
		passgr.setNomerKtp(noKtp);
		order.setPassanger(passgr);
		busService.checkoutBus(order);
		MainView.show();
	}

	private void train() {

	}

	private void plane() {

	}

}
