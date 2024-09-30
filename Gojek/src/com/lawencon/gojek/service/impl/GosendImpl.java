package com.lawencon.gojek.service.impl;

import com.lawencon.gojek.constant.Driver;
import com.lawencon.gojek.constant.KodeTrx;
import com.lawencon.gojek.model.Gosend;
import com.lawencon.gojek.model.OrderGosend;
import com.lawencon.gojek.model.OrderList;
import com.lawencon.gojek.service.OrderService;

public class GosendImpl implements OrderService<Gosend> {
	private OrderList orderlist;

    public GosendImpl(OrderList orderlist) {
        this.orderlist = orderlist; 
    }

	@Override
	public String addOrder(Gosend gosend) {
		String driver;
		int price;
		String codeTrx;
		if (orderlist.getActiveDriver().size() == 0) {
			driver = Driver.DRIVER1.getNamDriver();
			price = Driver.DRIVER1.getPrice() + gosend.getDistance()*1000 + gosend.getWeightItem()*1000;
			codeTrx = KodeTrx.GOSEND.getCodeTrx() + "1";
			orderlist.getActiveOrderGosend().put(codeTrx, new OrderGosend(codeTrx, driver, gosend, price));
			orderlist.getActiveDriver().add(driver);
			return codeTrx;
		}

		for (Driver driverEnum : Driver.values()) {
			if (!orderlist.getActiveDriver().contains(driverEnum.getNamDriver())) {
				driver = driverEnum.getNamDriver();
				price = driverEnum.getPrice() + gosend.getDistance()*1000 + gosend.getWeightItem()*1000;
				codeTrx = KodeTrx.GOSEND.getCodeTrx() + (orderlist.getActiveOrderGosend().size() + 1);
				orderlist.getActiveOrderGosend().put(codeTrx, new OrderGosend(codeTrx, driver, gosend, price));
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
		System.out.println("Driver : " + orderlist.getActiveOrderGosend().get(codeTrx).getCodeTrx());
		System.out.println("Driver : " + orderlist.getActiveOrderGosend().get(codeTrx).getDriver());
		System.out.println("Price : Rp " + orderlist.getActiveOrderGosend().get(codeTrx).getPrice());
		System.out.println("Posision : " + orderlist.getActiveOrderGosend().get(codeTrx).getGosend().getAddressPosision());
		System.out.println("Reciever : " + orderlist.getActiveOrderGosend().get(codeTrx).getGosend().getReciver());
		System.out.println("No Hp: " + orderlist.getActiveOrderGosend().get(codeTrx).getGosend().getNoHp());
		System.out.println("Item Name : " + orderlist.getActiveOrderGosend().get(codeTrx).getGosend().getItem());
		System.out.println("Type : " + orderlist.getActiveOrderGosend().get(codeTrx).getGosend().getTypeItem());
		System.out.println("Weight : " + orderlist.getActiveOrderGosend().get(codeTrx).getGosend().getWeightItem());
	}
}
