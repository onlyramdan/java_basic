package com.lawencon.gojek.constant;

public enum KodeTrx {
	GORIDE("GRD"), GOSEND("GSD"), GOFOOD("GFD");

	private String codeTrx;

	private KodeTrx(String codeTrx) {
		this.codeTrx = codeTrx;
	}
	
	public String getCodeTrx() {
		return codeTrx;
	}

	public void setCodeTrx(String codeTrx) {
		this.codeTrx = codeTrx;
	}

}
