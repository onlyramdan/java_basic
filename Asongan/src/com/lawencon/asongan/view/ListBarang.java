package com.lawencon.asongan.view;

import java.util.List;

import com.lawencon.asongan.model.Cart;
import com.lawencon.asongan.model.Category;
import com.lawencon.asongan.model.Item;
import com.lawencon.asongan.model.Transaksi;
import com.lawencon.asongan.service.CartService;
import com.lawencon.asongan.service.CategoryService;
import com.lawencon.asongan.service.impl.CartImpl;
import com.lawencon.asongan.service.impl.CategoryImpl;
import com.lawencon.asongan.util.KodeTrx;
import com.lawencon.asongan.util.ScannerUtil;

public class ListBarang {
	private CategoryService categoryService = new CategoryImpl();
	private CartService cartService = new CartImpl();
	List<Category> category = categoryService.getAllCategory();
	List<Cart> cart = cartService.getCart();

	public void show() {
		System.out.println("==== List Barang ====");
		int number = 1;
		for (Category categories : category) {
			System.out.println(number + "." + categories.name());
			number++;
		}

		System.out.println("5. Keranjang Belanja");

		int option = ScannerUtil.scannerInt("Input Menu:", 1, 5);
		switch (option) {
		case 1:
			buah(option - 1);
			break;
		case 2:
			sayuran(option - 1);
			break;
		case 3:
			mei(option - 1);
			break;
		case 4:
			air(option - 1);
		case 5:
			cart();
			break;
		default:
			break;

		}

	}

	private void air(int index) {
		System.out.println("==== List Air ====");
		List<Item> itemAir = category.get(index).items();
		int number = 1;
		for (Item items : itemAir) {
			System.out.print(number + "." + items.name());
			System.out.println("    Rp." + items.price());
			number++;
		}
		int itemNumber = ScannerUtil.scannerInt("Pilih Item:", 1, number-1);
		int itemQty = ScannerUtil.scannerInt("Masuk Jumlah:", 1, 1000);
		Cart cart = new Cart();
		cart.setJumlah(itemQty);
		cart.setNama(itemAir.get(itemNumber - 1).name());
		cart.setSubTotal(itemAir.get(itemNumber- 1).price() * itemQty);
		Cart cartDetail = cartService.addCart(cart);
		System.out.println("Nama : " + cartDetail.getNama());
		System.out.println("Jumlah: " + cartDetail.getJumlah());
		System.out.println("Rp :" + cartDetail.getSubTotal());
		show();
	}

	private void mei(int index) {
		System.out.println("==== List Mie ====");
		List<Item> itemMie = category.get(index).items();
		int number = 1;
		for (Item items : itemMie) {
			System.out.print(number + "." + items.name());
			System.out.println("    Rp." + items.price());
			number++;
		}
		int itemNumber = ScannerUtil.scannerInt("Pilih Item:", 1, number-1);
		int itemQty = ScannerUtil.scannerInt("Masuk Jumlah:", 1, 1000);
		Cart cart = new Cart();
		cart.setJumlah(itemQty);
		cart.setNama(itemMie.get(itemNumber - 1).name());
		cart.setSubTotal(itemMie.get(itemNumber- 1).price() * itemQty);
		Cart cartDetail = cartService.addCart(cart);
		System.out.println("Nama : " + cartDetail.getNama());
		System.out.println("Jumlah: " + cartDetail.getJumlah());
		System.out.println("Rp :" + cartDetail.getSubTotal());
		show();

	}

	private void sayuran(int index) {
		System.out.println("==== List Sayur ====");
		List<Item> itemSayur = category.get(index).items();
		int number = 1;
		for (Item items : itemSayur) {
			System.out.print(number + "." + items.name());
			System.out.println("    Rp." + items.price());
			number++;
		}
		int itemNumber = ScannerUtil.scannerInt("Pilih Item:", 1, number-1);
		int itemQty = ScannerUtil.scannerInt("Masuk Jumlah:", 1, 1000);
		Cart cart = new Cart();
		cart.setJumlah(itemQty);
		cart.setNama(itemSayur.get(itemNumber- 1).name());
		cart.setSubTotal(itemSayur.get(itemNumber- 1).price() * itemQty);
		Cart cartDetail = cartService.addCart(cart);
		System.out.println("Nama : " + cartDetail.getNama());
		System.out.println("Jumlah: " + cartDetail.getJumlah());
		System.out.println("Rp :" + cartDetail.getSubTotal());
		show();
	}

	private void cart() {
		System.out.println("==== List Cart ====");
		int number = 1;
		for (Cart carts : cart) {
			System.out.print(number + "." + carts.getNama());
			System.out.print("       Jumlah :" + carts.getJumlah());
			System.out.println("     Sub total Rp." + carts.getSubTotal());
			number++;
		}

		String menuCart = """


				1. Ubah Qty
				2. Hapus Barang
				3. Checkout
				4. Back

				""";
		System.out.println(menuCart);
		int option = ScannerUtil.scannerInt("Input Menu : ", 1, 4);
		switch (option) {
		case 1:
			editQty(number);
			break;
		case 2:
			deleteItem(number);
			break;
		case 3:
			checkout();
			break;
		case 4:
			show();
			break;
		default:
			break;
		}

	}

	private void checkout() {
		Transaksi  trx = new Transaksi();
		trx.setGrandTotal(cartService.getGrandTotal());
		trx.setNoTransaksi(new KodeTrx().generteCode());
		Transaksi trxdetail = MainView.transaksiService.addTransaksi(trx);
		System.out.println("Nomer Transaksi:" + trxdetail.getNoTransaksi());
		System.out.println("GranTotal: Rp." + trxdetail.getGrandTotal());
		MainView.show();
	}

	private void deleteItem(int number) {
		int item = ScannerUtil.scannerInt("Pilih Nomer Item : ", 1, number-1);
		cartService.deleteOneCart(item - 1);
		cart();
	}

	private void editQty(int number) {
		int item = ScannerUtil.scannerInt("Pilih Nomer Item : ", 1, number-1);
		int itemQty = ScannerUtil.scannerInt("Jumlah Qty: ", 1, 100);
		cartService.updateCart(item - 1, itemQty);
		cart();

	}

	public void buah(int index) {
		System.out.println("==== List Buah ====");
		List<Item> itemBuah = category.get(index).items();
		int number = 1;
		for (Item items : itemBuah) {
			System.out.print(number + "." + items.name());
			System.out.println("    Rp." + items.price());
			number++;
		}
		int itemNumber = ScannerUtil.scannerInt("Pilih Item:", 1, number-1);
		int itemQty = ScannerUtil.scannerInt("Masuk Jumlah:", 1, 1000);
		Cart cart = new Cart();
		cart.setJumlah(itemQty);
		cart.setNama(itemBuah.get(itemNumber - 1).name());
		cart.setSubTotal(itemBuah.get(itemNumber- 1).price() * itemQty);
		Cart cartDetail = cartService.addCart(cart);
		System.out.println("Nama: " + cartDetail.getNama());
		System.out.println("Jumlah: " + cartDetail.getJumlah());
		System.out.println("Rp :" + cartDetail.getSubTotal());
		show();
	}

}
