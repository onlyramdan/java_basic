package com.lawencon.BookStore;

import java.util.Random;

public class InvoiceCode {
	private final String CHRACTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private final int INVOICE_LENGHT = 10;
	public String generateCodeInvoice(){
		StringBuilder invoiceCode = new StringBuilder(INVOICE_LENGHT);
		Random random = new Random();
		
		for(int i= 0; i < INVOICE_LENGHT;i++){
			int index = random.nextInt(CHRACTER.length());
			invoiceCode.append(CHRACTER.charAt(index));
		}
		return invoiceCode.toString();
	}
}
