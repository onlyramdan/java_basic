package com.lawencon.day2;

public class SampleStatic {
	
	/**
	 * Static ini yang hanya bisa digunakkan hanya pada Kelas ini karena adany
	 * keyword static
	 */
	public static String name ="Jhon Whick";
	
	public static String getName() {
		return "Jhon Doe";
	}
	
	public void caller(){
		String myName = SampleStatic.name;
		String myAnotherName = SampleStatic.getName();
	}
}
