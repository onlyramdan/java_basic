package com.lawencon.oop;

public class Anak extends Induk {

	@Override
	void makan() {
		System.out.println("Anak Umur 1 Tahun Makan Asi");
	}

	public void namaAyahKu() {
		System.out.println("Nama Ayahku adalah " + namaAyah);
	}

}
