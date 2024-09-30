package com.lawencon.minimarket.constant;

public enum UserConstant {
	PEMBELI("pembeli","pembeli"),PENJUAL("penjual","penjual");
	
	private String username;
	private String password;
	
	
	UserConstant(String username, String password) {
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
