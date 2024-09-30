package com.lawencon.ojolsantuy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.ojolsantuy.model.Driver;
import com.lawencon.ojolsantuy.service.DriverService;

public class DriverServiceImpl implements DriverService{

	
	@Override
	public Driver findDriver() {
		final List<Driver> drivers = new ArrayList<Driver>();
		//Driver 1
		final Driver john = new Driver();
		john.setFullName("John Doe");
		john.setHp("08183218482");
		john.setPlatNo("B 123 ABC");
		drivers.add(john);
		//Driver 2
		final Driver budi = new Driver();
		budi.setFullName("Budi");
		budi.setHp("0812938123");
		budi.setPlatNo("B 451 ASD");
		drivers.add(budi);
		//Driver 3
		final Driver santo = new Driver();
		santo.setFullName("Santo");
		santo.setHp("0812382189");
		santo.setPlatNo("B 35 DSA");
		drivers.add(santo);
		//Driver 4
		final Driver joseph = new Driver();
		joseph.setFullName("joseph");
		joseph.setHp("08123314125");
		joseph.setPlatNo("B 997 POI");
		drivers.add(joseph);
		//Driver 5
		final Driver adit = new Driver();
		adit.setFullName("adit");
		adit.setHp("08192581928");
		adit.setPlatNo("B 123 SA");
		drivers.add(adit);
		//Driver 6
		final Driver firman = new Driver();
		firman.setFullName("firman");
		firman.setHp("08193212009");
		firman.setPlatNo("B 9 NCN");
		drivers.add(firman);
		//Driver 7
		final Driver fahmi = new Driver();
		fahmi.setFullName("fahmi");
		fahmi.setHp("08782947283723");
		fahmi.setPlatNo("B 8 QWE");
		drivers.add(fahmi);
		//Driver 8
		final Driver rico = new Driver();
		rico.setFullName("rico");
		rico.setHp("08192581928");
		rico.setPlatNo("B 451 KOY");
		drivers.add(rico);
		//Driver 9
		final Driver anggi = new Driver();
		anggi.setFullName("Anggi");
		anggi.setHp("081829172982");
		anggi.setPlatNo("B 9 TYT");
		drivers.add(anggi);
		//Driver 10
		final Driver rendy = new Driver();
		rendy.setFullName("Rendy");
		rendy.setHp("08132178219");
		rendy.setPlatNo("B 77 WOL");
		drivers.add(rendy);
		final int randomNum = (int) Math.floor(Math.random() * (10-1)+1);
		return drivers.get(randomNum);
	}
	
}
