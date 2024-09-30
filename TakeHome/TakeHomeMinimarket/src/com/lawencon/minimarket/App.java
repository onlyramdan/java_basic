package com.lawencon.minimarket;

import com.lawencon.minimarket.service.CategoryService;
import com.lawencon.minimarket.service.ItemService;
import com.lawencon.minimarket.service.TransaksiService;
import com.lawencon.minimarket.service.Impl.CategoryServiceImpl;
import com.lawencon.minimarket.service.Impl.ItemServiceImpl;
import com.lawencon.minimarket.service.Impl.TransaksiServiceImpl;
import com.lawencon.minimarket.view.LoginView;

public class App {
	public static ItemService itemService = new ItemServiceImpl();
	public static CategoryService categoryService = new CategoryServiceImpl();
	public static TransaksiService transaksiService = new TransaksiServiceImpl();
	public static void main(String[] args) {
		LoginView.login();
	}

}
