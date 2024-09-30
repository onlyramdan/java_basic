package com.lawencon.BookStore;

import java.util.*;

public class History {
	public final List<ItemHistory> history = new ArrayList<>();
	
	public void addHistory(String invoiceCode, String time , double price){
		history.add(0, new ItemHistory(invoiceCode, time, price));
	}

	public List<ItemHistory> getHistory() {
		return history;
	}
	
}
