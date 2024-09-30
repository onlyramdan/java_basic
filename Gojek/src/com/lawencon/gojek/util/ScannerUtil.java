package com.lawencon.gojek.util;

import java.util.Scanner;

public class ScannerUtil {
	private static Scanner scan;
	
	public static byte scanByte(){
		try {
			scan = new Scanner(System.in);
			return scan.nextByte();
		}catch(Exception e) {
			System.out.println("Input Error!");
			return -1;
		}
	}
	
	public static String scanString(){
		try {
			scan = new Scanner(System.in);
			return scan.nextLine();
		}catch(Exception e) {
			System.out.println("Input Error!");
			return "";
		}
	}
	

}
