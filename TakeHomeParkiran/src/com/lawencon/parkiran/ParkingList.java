package com.lawencon.parkiran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParkingList {
	public List<Vihicle> parkingList = new ArrayList<>();
	public Map<String, Vihicle> activeTickets = new HashMap<>();
	public Map<String, Vihicle> activePlate = new HashMap<>();
	
	/*
	 * (key : value)
	 */
	
    public Set<String> parkedVehicles = new HashSet<>(); 
    
    /*
	 * (value)
	 */
    
    public Map<String, Vihicle> getActiveTickets() {
		return activeTickets;
	}
    
	public Map<String, Vihicle> getActivePlate() {
		return activePlate;
	}

	public Set<String> getParkedVehicles() {
		return parkedVehicles;
	}

	public List<Vihicle> getParkingList() {
		return parkingList;
	}

}
