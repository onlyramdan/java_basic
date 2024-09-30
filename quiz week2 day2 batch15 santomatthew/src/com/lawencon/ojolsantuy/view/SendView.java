package com.lawencon.ojolsantuy.view;

import com.lawencon.ojolsantuy.constant.ItemType;
import com.lawencon.ojolsantuy.model.Driver;
import com.lawencon.ojolsantuy.service.DriverService;
import com.lawencon.ojolsantuy.service.SendService;
import com.lawencon.ojolsantuy.util.ScannerUtil;

public class SendView {
	
	private ItemType[] itemType = ItemType.values();
	private final SendService sendService;
	private final DriverService driverService;
	
	public SendView(SendService sendService,DriverService driverService) {
		this.sendService = sendService;
		this.driverService = driverService;
	}
	
	void show() {
		System.out.println("===== Send Santuys =====");
		
		for(int i=0;i<itemType.length;i++) {
			System.out.println((i+1)+ ". "+ itemType[i].name);
		}
		final int inputItemType = ScannerUtil.scannerInt("Pilih jenis barang : ", 1, itemType.length);
		final String chosenItemType = itemType[inputItemType-1].name;
		final int chosenItemPrice = itemType[inputItemType-1].price;
		
		final Double inputWeight = ScannerUtil.scannerDouble("Masukkan berat barang : ", 0);
		
		final String senderCity = ScannerUtil.scannerStr("Alamat Pengirim : ");
		
		final String receiverCity = ScannerUtil.scannerStr("Alamat Penerima : ");
		
		final double total = sendService.calculatePrice(senderCity, receiverCity, inputWeight, chosenItemPrice);
		final Driver driver = driverService.findDriver();
		
		
		System.out.println("===== Details =====");
		System.out.println("Jenis Barang : " + chosenItemType);
		System.out.println("Berat Barang : "+ inputWeight);
		System.out.println("Kota Pengirim : "+ senderCity);
		System.out.println("Kota Penerima : "+ receiverCity);
		System.out.println("Total Biaya = Rp. "+ total);

		System.out.println("===== Details Driver =====");
		System.out.println("Nama : "+driver.getFullName());
		System.out.println("Plat No : "+driver.getPlatNo());
		System.out.println("Hp : "+driver.getHp());
	
		
	}
	
	
}
