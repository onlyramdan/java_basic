package com.lawencon.gojek.model;

public class Gosend extends Goride {
	private String reciver;
	private String noHp;
	private String item;
	private String typeItem;
	private int weightItem;

	public Gosend(String addressPosision, String addressDestination, int distance , String reciver, String noHp, String item,
			String typeItem, int wightItem) {
		super(addressPosision, addressDestination, distance);
		this.reciver = reciver;
		this.noHp = noHp;
		this.item = item;
		this.typeItem = typeItem;
		this.weightItem = wightItem;
	}

	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getTypeItem() {
		return typeItem;
	}

	public void setTypeItem(String typeItem) {
		this.typeItem = typeItem;
	}

	public int getWeightItem() {
		return weightItem;
	}

	public void setWeightItem(int weightItem) {
		this.weightItem = weightItem;
	}

}
