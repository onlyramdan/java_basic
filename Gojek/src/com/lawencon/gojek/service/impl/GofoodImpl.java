package com.lawencon.gojek.service.impl;

import com.lawencon.gojek.constant.Driver;
import com.lawencon.gojek.constant.KodeTrx;
import com.lawencon.gojek.model.Gofood;
import com.lawencon.gojek.model.OrderGofood;
import com.lawencon.gojek.model.OrderList;
import com.lawencon.gojek.service.GofoodService;

public class GofoodImpl implements GofoodService<Gofood> {
	private OrderList orderlist;
	private int total_price = 0;
	private int qty = 0;

	public GofoodImpl(OrderList orderlist) {
		this.orderlist = orderlist;
	}

	@Override
	public String addOrder() {
		String codeTrx;
		String driver;
		int price;
		if (orderlist.getActiveDriver().size() == 0) {
			driver = Driver.DRIVER1.getNamDriver();
			price = Driver.DRIVER1.getPrice() * 1000 + total_price;
			codeTrx = KodeTrx.GORIDE.getCodeTrx() + "1";
			orderlist.getActiveOrderGofood().put(codeTrx, new OrderGofood(codeTrx, driver, price, qty));
			orderlist.getActiveDriver().add(driver);
			return codeTrx;
		}
		for (Driver driverEnum : Driver.values()) {
			if (!orderlist.getActiveDriver().contains(driverEnum.getNamDriver())) {
				driver = driverEnum.getNamDriver();
				price = Driver.DRIVER1.getPrice() + total_price;
				codeTrx = KodeTrx.GORIDE.getCodeTrx() + (orderlist.getActiveOrderGofood().size() + 1);
				orderlist.getActiveOrderGofood().put(codeTrx, new OrderGofood(codeTrx, driver, price, qty));
				orderlist.getActiveDriver().add(driver);
				return codeTrx;
			}
		}
		return "Not Found Driver Available";
	}

	@Override
	public void getOrder(String codeTrx) {
		System.out.println("----------------------------");
		System.out.println("Detail : ");
		System.out.println("Code Trascation : " + orderlist.getActiveOrderGofood().get(codeTrx).getCodeTrx());
		System.out.println("Driver : " + orderlist.getActiveOrderGofood().get(codeTrx).getDriver());
		System.out.println("Price : Rp " + orderlist.getActiveOrderGofood().get(codeTrx).getPrice());
		System.out.println(
				"Qty : " + orderlist.getActiveOrderGofood().get(codeTrx).getQty());
	}

	@Override
	public void addMenu(Gofood gofoodlist) {
		if (orderlist.getGofoodList().isEmpty()) {
			orderlist.getGofoodList().add(gofoodlist);
		} else {
			boolean find = false;
			for (int i = 0; i < orderlist.getGofoodList().size(); i++) {
				if (orderlist.getGofoodList().get(i).getMenu().equals(gofoodlist.getMenu())) {
					int qty = gofoodlist.getQty() + orderlist.getGofoodList().get(i).getQty();
					int price = gofoodlist.getPriceMenu() + orderlist.getGofoodList().get(i).getPriceMenu();
					gofoodlist.setQty(qty);
					gofoodlist.setPriceMenu(price);
					orderlist.getGofoodList().set(i, gofoodlist);
					find = true;
					break;
				}
			}
			if (find != true) {
				orderlist.getGofoodList().add(gofoodlist);
			}
		}
	}

	@Override
	public void getlist() {
		int number = 1;
		if (orderlist.getGofoodList().isEmpty()) {
			System.out.println("\n------ No List Order -----\n");
		} else {
			total_price = 0;
			qty = 0;
			for (Gofood gofoods : orderlist.getGofoodList()) {
				System.out.print(number + ".  ");
				System.out.print(" | Resto: " + gofoods.getRestoran());
				System.out.print(" | Menu: " + gofoods.getMenu());
				System.out.print(" | Qty: " + gofoods.getQty());
				System.out.println(" | Rp. " + gofoods.getPriceMenu());
				total_price += gofoods.getPriceMenu();
				qty += gofoods.getQty();
				number++;
			}

			System.out.println("\nTotal Price : " + total_price + "\n");
		}

	}

	@Override
	public boolean editListQty(int index, int qty) {
		Gofood gofoods = orderlist.getGofoodList().get(index);
		int hargaSatuan = orderlist.getGofoodList().get(index).getPriceMenu()
				/ orderlist.getGofoodList().get(index).getQty();
		gofoods.setQty(qty);
		gofoods.setPriceMenu(hargaSatuan * qty);
		orderlist.getGofoodList().set(index, gofoods);
		System.out.println("Susccessfully Update");
		return true;
	}

	@Override
	public boolean deleteOne(int index) {
		orderlist.getGofoodList().remove(index);
		System.out.println("Susccessfully Delete");
		return true;
	}

	@Override
	public boolean deleteAll() {
		orderlist.getGofoodList().clear();
		total_price = 0;
		qty = 0;
		System.out.println("Susccessfully Cencel");
		return true;
	}

	@Override
	public OrderGofood getCheckout() {
		return null;
	}

}
