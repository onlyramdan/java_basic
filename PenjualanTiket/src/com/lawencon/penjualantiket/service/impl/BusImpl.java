package com.lawencon.penjualantiket.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.penjualantiket.constant.KodeKendaraan;
import com.lawencon.penjualantiket.model.Bus;
import com.lawencon.penjualantiket.model.ListOder;
import com.lawencon.penjualantiket.model.Order;
import com.lawencon.penjualantiket.model.Seat;
import com.lawencon.penjualantiket.service.BusService;

public class BusImpl implements BusService {	
	private ListOder listOrder;

	public BusImpl(ListOder listOrder) {
		this.listOrder= listOrder;
	}
	
	
	
	@Override
	public void getSeat(int numberBus) {
		System.out.println("Kusi Yang Tersedia");
		for (Seat seats : listOrder.getBus().get(numberBus-1).getSeat()) {
			if (seats.isAvail()) {
				System.out.println(seats.getSeatNumber());
			}
		}
	}
	
	@Override
	public List<Bus> getBusList() {
		if (listOrder.getBus().isEmpty()) {
			
		List<Seat> seat = new ArrayList<>();
		Bus bus1 = new Bus();
		Seat seatBus11 = new Seat();
		Seat seatBus12 = new Seat();
		Seat seatBus13 = new Seat();
		Seat seatBus14 = new Seat();

		bus1.setName("BUS 1");
		bus1.setFrom("Bandung");
		bus1.setTo("Jakarta");
		bus1.setPrice(50000);
		LocalDate data = LocalDate.of(2024, 9, 26);
		bus1.setDate(data);

		seatBus11.setSeatNumber(1);
		seatBus11.setAvail(true);
		seat.add(seatBus11);

		seatBus12.setSeatNumber(2);
		;
		seatBus12.setAvail(true);
		seat.add(seatBus12);

		seatBus13.setSeatNumber(3);
		seatBus13.setAvail(true);
		seat.add(seatBus13);

		seatBus14.setSeatNumber(4);
		seatBus14.setAvail(true);
		seat.add(seatBus14);

		bus1.setSeat(seat);
		listOrder.getBus().add(bus1);
	}
		
		return listOrder.getBus();
	}

	@Override
	public void orderBus(int seat, int numberBus) { 
		int seatNumber = 0;
		for(Seat seatList : listOrder.getBus().get(numberBus-1).getSeat()){
			if (seatList.getSeatNumber() == seat ) {
				break;
			}
			seatNumber++;
		}
		Seat seatopsi = listOrder.getBus().get(numberBus - 1).getSeat().get(seatNumber);
		seatopsi.setAvail(false);
	}

	@Override
	public void checkoutBus(Order order) {
		String kodeTrx = KodeKendaraan.BUS.toString() + order.getNumberKendaraan() + order.getSeatNumber();
		order.setDate(listOrder.getBus().get(order.getNumberKendaraan() - 1).getDate());
		order.setNoTrx(kodeTrx);
		listOrder.getOrderBus().add(order);
		System.out.println("Success Detail :");
		System.out.println("No Trx : " + order.getNoTrx());
		System.out.println("No ktp : " + order.getPassanger().getNomerKtp());
		System.out.println("Waktu: " + order.getDate().toString());
		System.out.println("Rp. : " + order.getPrice());

	}

	@Override
	public int getPrice(int numberBus) {
		int price = listOrder.getBus().get(numberBus-1).getPrice();
		return price;
	}

	@Override
	public void getCheckout() {

	}

}
