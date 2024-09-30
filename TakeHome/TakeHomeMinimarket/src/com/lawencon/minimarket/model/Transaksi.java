package com.lawencon.minimarket.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaksi {
	private String nomerTransaksi;
	private LocalDate waktuTransaksi;
	private Integer grandTotal;

	public String getNomerTransaksi() {
		return nomerTransaksi;
	}

	public void setNomerTransaksi(String nomerTransaksi) {
		this.nomerTransaksi = nomerTransaksi;
	}

	public LocalDate getWaktuTransaksi() {
		return waktuTransaksi;
	}

	public void setWaktuTransaksi(LocalDate waktuTransaksi) {
		this.waktuTransaksi = waktuTransaksi;
	}

	public Integer getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Integer grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String toStringList(){
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 return String.format("%s | %s | Rp. %,d",
		            nomerTransaksi, 
		            waktuTransaksi.format(dateFormatter), 
		            grandTotal);
	
	}
	
	public String trxDetail() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return String.format("""
				Detail Transaksi 
				Nomer Transaksi : %s
				Waktu Transaksi : %s
				GrandTotal :Rp. %d
				""",nomerTransaksi, waktuTransaksi.format(dateFormatter),grandTotal );
	}
}
