package com.lawencon.gojek.service.impl;

import com.lawencon.gojek.constant.Driver;
import com.lawencon.gojek.constant.KodeTrx;
import com.lawencon.gojek.model.Goride;
import com.lawencon.gojek.model.OrderGoride;
import com.lawencon.gojek.model.OrderList;
import com.lawencon.gojek.service.OrderService;

public class GorideImpl implements OrderService<Goride> {
	private OrderList orderlist;

	public GorideImpl(OrderList orderlist) {
		this.orderlist = orderlist;
	}

	@Override
	public String addOrder(Goride goride) {
		String codeTrx;
		String driver;
		int price;
		if (orderlist.getActiveDriver().size() == 0) {
			driver = Driver.DRIVER1.getNamDriver();
			price = Driver.DRIVER1.getPrice() + goride.getDistance() * 1000;
			codeTrx = KodeTrx.GORIDE.getCodeTrx() + "1";
			orderlist.getActiveOrder().put(codeTrx, new OrderGoride(codeTrx, driver, goride, price));
			orderlist.getActiveDriver().add(driver);
			return codeTrx;
		}
		for (Driver driverEnum : Driver.values()) {
			if (!orderlist.getActiveDriver().contains(driverEnum.getNamDriver())) {
				driver = driverEnum.getNamDriver();
				price = driverEnum.getPrice() + goride.getDistance() * 1000;
				codeTrx = KodeTrx.GORIDE.getCodeTrx() + (orderlist.getActiveOrder().size() + 1);
				orderlist.getActiveOrder().put(codeTrx, new OrderGoride(codeTrx, driver, goride, price));
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
		System.out.println("Code Trascation : " + orderlist.getActiveOrder().get(codeTrx).getCodeTrx());
		System.out.println("Driver : " + orderlist.getActiveOrder().get(codeTrx).getDriver());
		System.out.println("Price : Rp " + orderlist.getActiveOrder().get(codeTrx).getPrice());
		System.out.println("Posision : " + orderlist.getActiveOrder().get(codeTrx).getGoride().getAddressPosision());
		System.out.println("Destionation : " + orderlist.getActiveOrder().get(codeTrx).getGoride().getAddressDestination());
	}

}
