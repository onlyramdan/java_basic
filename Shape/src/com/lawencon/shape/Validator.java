package com.lawencon.shape;

public class Validator {
	public boolean isValidNumber(double number){
		if(number <= 0 ) {
			System.out.println("Invalid Number!!!");
			return false;
		}
		return true;
	}
}
