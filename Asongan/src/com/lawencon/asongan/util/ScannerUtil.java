package com.lawencon.asongan.util;

import java.util.Scanner;

public class ScannerUtil {

	public static int scannerInt(String question, int min, int max) {
		System.out.print(question);
		@SuppressWarnings("resource")
		final Scanner scan = new Scanner(System.in);
		try {
			final String input = scan.nextLine().trim();
			final InputChecker inputChecker = new InputChecker();
			final Boolean inputIsString = inputChecker.isString(input);
			if (inputIsString) {
				System.out.println("Invalid Input");
				return scannerInt(question, min, max);
			} else {
				final int inputValue = Integer.parseInt(input);
				final Boolean isInputOutOfRange = inputChecker.isOutOfRange(inputValue, min, max);
				if (isInputOutOfRange) {
					return scannerInt(question, min, max);
				} else {
					return inputValue;
				}
			}
		} catch (Exception e) {
			return scannerInt(question, min, max);
		}
	}

	public static Double scannerDouble(String question, int min) {
		System.out.print(question);
		@SuppressWarnings("resource")
		final Scanner scan = new Scanner(System.in);
		try {
			final String input = scan.nextLine().trim();
			final InputChecker inputChecker = new InputChecker();
			final Boolean inputIsString = inputChecker.isString(input);
			if (inputIsString) {
				System.out.println("Invalid Input");
				return scannerDouble(question, min);
			} else {
				final Double inputValue = Double.parseDouble(input);
				final Boolean isInputLessThanMin = inputChecker.isLessThanMin(inputValue, min);
				if (isInputLessThanMin) {
					return scannerDouble(question, min);
				} else {
					return inputValue;
				}
			}
		} catch (Exception e) {
			return scannerDouble(question, min);
		}
	}

	public static String scannerStr(String question) {
		System.out.print(question);
		@SuppressWarnings("resource")
		final Scanner scan = new Scanner(System.in);
		final String name = scan.nextLine();
		final String nameChecker = name.trim();
		if (nameChecker.equals("")) {
			System.out.println("Invalid Input");
			return scannerStr(question);
		} else {
			return name;
		}
	}

}
