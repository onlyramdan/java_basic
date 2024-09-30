package com.lawencon.oop;

public class App {

	public static void main(String[] args) {
		/*
		 * 
		 */
		AnakInterface anak = new AnakInterface();
		anak.lari();
		anak.berenang();
		Nilai nilai = new Nilai();
		System.out.println("Nilai Ku : " + nilai.getGrade(80));
	}

}
