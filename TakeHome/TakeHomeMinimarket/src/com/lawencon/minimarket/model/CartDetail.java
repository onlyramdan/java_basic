package com.lawencon.minimarket.model;

public class CartDetail {
	private String name;
	private Integer subtotal;
	private Integer qty;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	public String detailCartPrint(){
		return String.format("""
				Cart Detail
				Name : %s
				Quantity : %d
				Sub Total : Rp. %d 
				""",name,qty,subtotal);
	}
	public String cartListString() {
		return String.format("""
				%s | Quantity : %d | Sub Total : %d
				""",name,qty,subtotal);
		
	}
	
}
