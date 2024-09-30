package com.lawencon.penjualantiket.constant;

public enum KodeKendaraan {
	BUS("BS"),TRAIN("TR"),PLANE("PST");
	
	private String kodeKendaran;

	private KodeKendaraan(String kodeKendaran) {
		this.kodeKendaran = kodeKendaran;
	}
	
	public String getKodeKendaran() {
		return kodeKendaran;
	}

	public void setKodeKendaran(String kodeKendaran) {
		this.kodeKendaran = kodeKendaran;
	}
	
	
}
