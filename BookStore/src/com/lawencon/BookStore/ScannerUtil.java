package com.lawencon.BookStore;

import java.util.Scanner;

public class ScannerUtil {
	private static Scanner scan;
	
	public static String scanString(){
		try {
			scan = new Scanner(System.in);
			return scan.nextLine();
		}catch(Exception e){
			System.out.println("Input Tidak Valid");
			return "";
		}
	}
	
	public static int scanInt(){
		try {
			scan = new Scanner(System.in);
			return scan.nextInt();
		}catch(Exception e){
			System.out.println("Input Tidak Valid");
			return 0;
		}
	}
	
}
