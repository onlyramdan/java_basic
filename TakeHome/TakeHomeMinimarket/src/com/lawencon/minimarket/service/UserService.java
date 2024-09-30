package com.lawencon.minimarket.service;

import com.lawencon.minimarket.model.User;

public interface UserService {
	Boolean login(String username, String password);
	User getUser(User user);
}