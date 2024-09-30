package com.lawencon.ojolsantuy.util;

public class InputChecker {

	public boolean isString (String input) {
		Boolean result = false;
		if (input.equals("")) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	public boolean isOutOfRange(int input, int min,int max) {
		Boolean result = false;
		if(input<min) {
			System.out.println("Input terlalu kecil");
			result = true;
		}
		else if(input>max) {
			System.out.println("Input melebihi batas");
			result = true;
		}
		return result;
	}
	
	public boolean isLessThanMin(Double input, int min) {
		Boolean result = false;
		if(input<min) {
			System.out.println("Input terlalu kecil");
			result = true;
		}
		
		return result;
	}
	
	
	
}
