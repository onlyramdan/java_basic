package com.lawencon.minimarket.view;

import com.lawencon.minimarket.App;
import com.lawencon.minimarket.model.CartDetail;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.model.Transaksi;
import com.lawencon.minimarket.service.CartService;
import com.lawencon.minimarket.service.Impl.CartServiceImpl;
import com.lawencon.minimarket.util.CodeUtil;
import com.lawencon.minimarket.util.DateUtil;
import com.lawencon.minimarket.util.ScannerUtil;

public class PembeliView {
	private static CartService serviceCart = new CartServiceImpl();

	public static void pembeliShow() {
		System.out.println("== Menu Pembeli ==");
		String menuPembeli = """
				1. View Item
				2. Cart
				3. History
				4. LogOut
				""";
		System.out.println(menuPembeli);
		int option = ScannerUtil.scannerInt("Input Menu :", 1, 4);
		switch (option) {
		case 1:
			viewItem();
			break;
		case 2:
			cart();
			break;
		case 3:
			history();
			break;
		case 4:
			LoginView.login();
			break;
		}
	}

	private static void cart() {
		System.out.println("== Menu Chart ==");
		int number = 1;
		for (CartDetail carts : serviceCart.getAll()) {
			System.out.print(number + "." + carts.cartListString());
			number++;
		}

		System.out.println("\nTotal Harga : Rp. " + serviceCart.getGrandTotal());
		
		String menuCart = """
				1. Edit Quantity
				2. Delete Cart
				3. Checkout
				4. Cancel
				5. Back
				""";
		System.out.println(menuCart);
		int option = ScannerUtil.scannerInt("Input Menu :", 1, 5);
		switch (option) {
		case 1:
			editQuatity();
			break;
		case 2:
			deleteItem();
			break;
		case 3:
			checkout();
			break;
		case 4:
			cancel();
			break;
		case 5:
			pembeliShow();
			break;
		}

	}

	private static void editQuatity() {
		System.out.println("== Edit Qty Item ==");
		int number = 1;
		if (serviceCart.getAll().size() == 0) {
			cart();
		}
		for (CartDetail carts : serviceCart.getAll()) {
			System.out.print(number + "." + carts.cartListString());
			number++;
		}

		int index = ScannerUtil.scannerInt("Input Nomer Item :", 1, number - 1);
		int qty = ScannerUtil.scannerInt("Input New Qty : ", 0, 10000);
		int qtyCart = serviceCart.getAll().get(index - 1).getQty();
		String nameItem = serviceCart.getAll().get(index - 1).getName();
		App.itemService.addQtyByName(qtyCart, nameItem);
		if (!App.itemService.deleteQtyName(qty, nameItem)) {
			System.out.println("Melebihi Stock yang tersedia");
			App.itemService.addQtyByName(-qtyCart, nameItem);
			cart();
		}
		serviceCart.updateCart(index - 1, qty);
		cart();

	}

	private static void deleteItem() {
		System.out.println("== Hapus Item ==");
		int number = 1;
		if (serviceCart.getAll().size() == 0) {
			cart();
		} else {
			for (CartDetail carts : serviceCart.getAll()) {
				System.out.print(number + "." + carts.cartListString());
				number++;
			}
		}

		int index = ScannerUtil.scannerInt("Input Nomer Item :", 1, number - 1);
		int qtyCart = serviceCart.getAll().get(index - 1).getQty();
		String nameItem = serviceCart.getAll().get(index - 1).getName();
		App.itemService.addQtyByName(qtyCart, nameItem);
		serviceCart.deleteOneCart(index - 1);
		cart();
	}

	private static void checkout() {
		if(serviceCart.getAll().size()==0) {
			cart();
		}
		Transaksi trx = new Transaksi();
		trx.setGrandTotal(serviceCart.getGrandTotal());
		trx.setNomerTransaksi(CodeUtil.generteCode());
		trx.setWaktuTransaksi(DateUtil.getDate());
		Transaksi detailTransaksi = App.transaksiService.addTransaksi(trx);
		serviceCart.deleteAll();
		System.out.println(detailTransaksi.trxDetail());
		System.out.println("Terima Kasih");
		pembeliShow();
	}

	private static void cancel() {
		for (CartDetail carts : serviceCart.getAll()) {
			App.itemService.addQtyByName(carts.getQty(), carts.getName());
		}
		serviceCart.deleteAll();
		System.out.println("Canceled!!!");
		pembeliShow();
	}

	private static void viewItem() {
		System.out.println("== View Item ==");
		String menuViewItem = """
				1. List Jenis Item
				2. View All Item
				3. Back
				""";
		System.out.println(menuViewItem);
		int option = ScannerUtil.scannerInt("Input Menu : ", 1, 4);
		switch (option) {
		case 1:
			showCategoryItem();
			break;
		case 2:
			showAllItem();
			break;
		case 3:
			pembeliShow();
			break;
		}
	}

	private static void showAllItem() {
		int number = 1;
		if (App.itemService.getAll().size() == 0) {
			viewItem();
		}
		for (Item items : App.itemService.getAll()) {
			System.out.print(number + ".");
			System.out.print(items.toStringList());
			number++;
		}
		int option = ScannerUtil.scannerInt("Pilih Nomer Item yang ingin dibeli : ", 1, number - 1);
		int qty = ScannerUtil.scannerInt("Input Jumlah :", 0, 100000);
		if (App.itemService.getQtyItemAndStock(option - 1, qty)) {
			System.out.println("Jumlah melebihi stok");
			showAllItem();
		}

		Item item = App.itemService.getItem(option - 1);
		CartDetail cart = new CartDetail();
		cart.setName(item.getName());
		cart.setQty(qty);
		cart.setSubtotal(item.getPrice() * qty);
		CartDetail cartadd = serviceCart.addCart(cart);
		item.setStock(item.getStock() - qty);
		App.itemService.getAll().set(option - 1, item);
		System.out.print(cartadd.detailCartPrint());
		pembeliShow();
	}

	private static void showCategoryItem() {
		System.out.println("== Kategori Barang ==");
		if (App.categoryService.getAll().size() == 0) {
			viewItem();
		}
		int number = 1;
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
		int number = 1;
		for (Item items : App.itemService.getAll()) {
			if (items.getCategory().getName().equals(category)) {
				System.out.print(number + "." + items.toStringList());
				number++;
			}
		}
		if (number == 1) {
			System.out.println("Tidak ada item di Kategori");
			viewItem();
		}

		int option = ScannerUtil.scannerInt("Pilih nomer Item yang dibeli :", 1, number - 1);
		int qty = ScannerUtil.scannerInt("Input Jumlah:", 0, 100000);

		if (App.itemService.getQtyItemAndStockCategory(option, qty, category)) {
			System.out.println("Jumlah melebihi stok");
			showAllItem();
		}

		Item item = App.itemService.getItemCategory(option, category);
		int indexItem = App.itemService.getAll().indexOf(item);
		CartDetail cart = new CartDetail();
		cart.setName(item.getName());
		cart.setQty(qty);
		cart.setSubtotal(item.getPrice() * qty);
		CartDetail cartadd = serviceCart.addCart(cart);
		item.setStock(item.getStock() - qty);
		App.itemService.getAll().set(indexItem, item);
		System.out.print(cartadd.detailCartPrint());
		pembeliShow();
	}

	private static void history() {
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

		int option = ScannerUtil.scannerInt("\n(1. Back)\nInput: ", 1, 1);
		if (option == 1) {
			pembeliShow();
		}
	}
}
