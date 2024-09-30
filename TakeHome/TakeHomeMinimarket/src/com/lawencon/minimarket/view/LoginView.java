package com.lawencon.minimarket.view;

import com.lawencon.minimarket.constant.UserConstant;
import com.lawencon.minimarket.model.User;
import com.lawencon.minimarket.service.UserService;
import com.lawencon.minimarket.service.Impl.UserServiceImpl;
import com.lawencon.minimarket.util.ScannerUtil;

public class LoginView {
	public static UserService userService = new UserServiceImpl();
	public static void login() {
		System.out.println("==== Login ====");
		String username = ScannerUtil.scannerStr("Input Username :");
		String password = ScannerUtil.scannerStr("Input Password :");
		Boolean isLogin = userService.login(username, password);
		if (isLogin) {
			System.out.println("Berhasil Login");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			User userLogin = userService.getUser(user);
			if(userLogin.getUsername().equals(UserConstant.PENJUAL.getUsername())){	
				PenjualView.penjualShow();
			}else {
				PembeliView.pembeliShow();
			}
		} else {
			login();
		}
	}
}
