package com.lawencon.gojek.constant;

import java.util.Arrays;
import java.util.List;

public enum Restoran {
    SEDERHANA(Arrays.asList(
        new Menu("Nasi Padang", 25000),
        new Menu("Rendang", 30000),
        new Menu("Ayam Pop", 28000),
        new Menu("Soto Padang", 22000),
        new Menu("Gulai Kikil", 32000)
    )),
    GACOAN(Arrays.asList(
        new Menu("Mie Setan", 15000),
        new Menu("Mie Iblis", 16000),
        new Menu("Dimsum", 12000),
        new Menu("Es Genderuwo", 10000),
        new Menu("Es Pocong", 10000)
    )),
    MCD(Arrays.asList(
        new Menu("Big Mac", 40000),
        new Menu("McChicken", 35000),
        new Menu("McNuggets", 30000),
        new Menu("French Fries", 15000),
        new Menu("Sundae", 10000)
    )),
    KFC(Arrays.asList(
        new Menu("Zinger Burger", 35000),
        new Menu("Chicken Bucket", 50000),
        new Menu("Twister", 25000),
        new Menu("Crispy Chicken", 20000),
        new Menu("French Fries", 15000)
    )),
    STARBUCKS(Arrays.asList(
        new Menu("Latte", 45000),
        new Menu("Cappuccino", 45000),
        new Menu("Espresso", 30000),
        new Menu("Frappuccino", 50000),
        new Menu("Caramel Macchiato", 55000)
    ));
	
    private List<Menu> menuList;

    Restoran(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}
