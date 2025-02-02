package com.lawencon.minimarket.view;

import com.lawencon.minimarket.App;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.model.Transaksi;
import com.lawencon.minimarket.util.ScannerUtil;

public class PenjualView {
	public static void penjualShow() {
		System.out.println("== Menu Penjual ==");
		String menuPenjual = """
				1. Transaksi Pembeli
				2. View Item
				3. LogOut
				""";
		System.out.println(menuPenjual);
		int option = ScannerUtil.scannerInt("Input Menu :", 1, 3);
		switch (option) {
		case 1:
			transaksiPembeli();
			break;
		case 2:
			viewItem();
			break;
		case 3:
			LoginView.login();
			break;
		}
	}

	private static void transaksiPembeli() {
		int number = 1;
		String formatHistory = """
				          History
				[No.Trx]  [tanggal]    [Harga]
				""";
		System.out.print(formatHistory);
		for (Transaksi trx : App.transaksiService.getAll()) {
			System.out.println(number + "." + trx.toStringList());
			number++;
		}

		int option = ScannerUtil.scannerInt("\n(1. Back)\nInput :", 1, 1);
		if (option == 1) {
			penjualShow();
		}
	}

	private static void viewItem() {
		System.out.println("== View Item ==");
		String menuViewItem = """
				1. List Jenis Item
				2. View All Item
				3. Tambah Item
				4. Hapus Item
				5. Update Item
				6. Back
				""";
		System.out.println(menuViewItem);
		int option = ScannerUtil.scannerInt("Input Menu : ", 1, 6);
		switch (option) {
		case 1:
			showCategoryItem();
			break;
		case 2:
			showAllItem();
			break;
		case 3:
			addItem();
			break;
		case 4:
			deleteItem();
			break;
		case 5:
			updateItem();
			break;
		case 6:
			penjualShow();
			break;
		}
	}

	private static void updateItem() {
		System.out.println("== Update Barang ==");
		int number = 1;
		for (Item items : App.itemService.getAll()) {
			System.out.print(number + ".");
			System.out.print(items.toStringList());
			number++;
		}
		if (App.itemService.getAll().size() == 0) {
			viewItem();
		}
		int index = ScannerUtil.scannerInt("Input Item Number : ", 1, number - 1);
		String name = ScannerUtil.scannerStr("Input Update Name: ");
		int stok = ScannerUtil.scannerInt("Input Update Stock: ", 0, 10000);
		int price = ScannerUtil.scannerInt("Input Update Harga: ", 0, 1000000);
		String categoryName = ScannerUtil.scannerStr("Input Category Name : ");
		Item item = new Item();
		Category category = App.categoryService.addCategories(categoryName);
		item.setName(name);
		item.setPrice(price);
		item.setStock(stok);
		item.setCategory(category);
		Item itemUpdate = App.itemService.updateItem(index - 1, item);
		System.out.println("Item Updated");
		System.out.println(itemUpdate.toString());
		viewItem();
	}

	private static void deleteItem() {
		System.out.println("== Hapus Barang ==");
		int number = 1;
		for (Item items : App.itemService.getAll()) {
			System.out.print(number + ".");
			System.out.print(items.toStringList());
			number++;
		}
		if (App.itemService.getAll().size() == 0) {
			viewItem();
		}
		int index = ScannerUtil.scannerInt("Input Item Number :", 1, number - 1);
		App.itemService.deleteOneItem(index - 1);
		viewItem();

	}

	private static void showAllItem() {
		int number = 1;
		for (Item items : App.itemService.getAll()) {
			System.out.print(number + ".");
			System.out.print(items.toStringList());
			number++;
		}
		viewItem();

	}

	private static void showCategoryItem() {
		System.out.println("== Kategori Barang ==");
		int number = 1;
		if (App.categoryService.getAll().size() == 0) {
			viewItem();
		}
		for (Category category : App.categoryService.getAll()) {
			System.out.print(number + ".");
			System.out.println(category.getName());
			number++;
		}

		int option = ScannerUtil.scannerInt("Input Category :", 1, number - 1);
		listCategoryItem(option - 1);
	}

	private static void listCategoryItem(int index) {
		String category = App.categoryService.getCategory(index);
		App.itemService.getItemByCategory(category);

		int option = ScannerUtil.scannerInt("\n(1. Back) \n Input :", 1, 1);
		if (option == 1) {
			viewItem();
		}
	}

	private static void addItem() {
		System.out.println("== Tambah Barang ==");
		Item item = new Item();
		Category category = new Category();
		String name = ScannerUtil.scannerStr("Input Nama Barang : ");
		item.setName(name);
		int price = ScannerUtil.scannerInt("Input Harga Barang : Rp. ", 0, 10000000);
		item.setPrice(price);
		int stok = ScannerUtil.scannerInt("Input Stock Barang : ", 0, 100);
		item.setStock(stok);
		String categoryItem = ScannerUtil.scannerStr("Input Jenis Barang : ");
		category = App.categoryService.addCategories(categoryItem);
		item.setCategory(category);
		System.out.println(App.itemService.addItem(item).toString());
		penjualShow();
	}
}
