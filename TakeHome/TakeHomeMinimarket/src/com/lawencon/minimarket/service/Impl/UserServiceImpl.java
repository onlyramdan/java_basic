package com.lawencon.minimarket.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.constant.UserConstant;
import com.lawencon.minimarket.model.User;
import com.lawencon.minimarket.service.UserService;

public class UserServiceImpl implements UserService {
	private List<User> userList = new ArrayList<>();

	public UserServiceImpl() {
		User userPenjual = new User();
		userPenjual.setUsername(UserConstant.PENJUAL.getUsername());
		userPenjual.setPassword(UserConstant.PENJUAL.getPassword());
		userList.add(userPenjual);

		User userPembeli = new User();
		userPembeli.setUsername(UserConstant.PEMBELI.getUsername());
		userPembeli.setPassword(UserConstant.PEMBELI.getPassword());
		userList.add(userPembeli);
	}

	@Override
	public Boolean login(String username, String password) {
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		
		if (!isUsernameValid(user)) {
			System.out.println("Username Invalid !!!");
			return false;
		}
		if (!isPasswordValid(user)) {
			System.out.println("Password Invalid !!!");
			return false;
		}
		return true;
	}

	private Boolean isUsernameValid(User user) {
		return userList.stream()
			.filter(u -> u.getUsername().equals(user.getUsername()))
			.findAny() 
			.isPresent();
	}

	private Boolean isPasswordValid(User user) {
		return userList.stream()
			.filter(u -> u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()))
			.findAny() 
			.isPresent(); 
	}

	@Override
	public User getUser(User user) {
		return userList.stream().filter(u -> u.getPassword().equals(user.getPassword()) && u.getUsername().equals(user.getUsername()))
			.findFirst()
			.orElse(null);
	}
}