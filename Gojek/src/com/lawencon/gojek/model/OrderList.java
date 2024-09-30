package com.lawencon.gojek.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderList {
	private Map<String, OrderGoride> activeOrder = new HashMap<>();
	private Map<String, OrderGosend> activerOrderGosend = new HashMap<>();
	private Set<String> activeDriver = new HashSet<>();
	private List<Gofood> gofoodList = new ArrayList<>();
	private Map<String, OrderGofood> activeOrderGofood = new HashMap<>();
	
	public List<Gofood> getGofoodList(){
		return gofoodList;
	}
	
	public Set<String> getActiveDriver(){
		return activeDriver;
	}

	public Map<String, OrderGoride> getActiveOrder() {
		return activeOrder;
	}
	
	public Map<String, OrderGosend> getActiveOrderGosend() {
		return activerOrderGosend;
	}

	public void setActiveOrder(Map<String, OrderGoride> activeOrder) {
		this.activeOrder = activeOrder;
	}

	public Map<String, OrderGofood> getActiveOrderGofood() {
		return activeOrderGofood;
	}

	public void setActiveOrderGofood(Map<String, OrderGofood> activeOrderGofood) {
		this.activeOrderGofood = activeOrderGofood;
	}

	
}
