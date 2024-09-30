package com.lawencon.asongan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.asongan.model.Category;
import com.lawencon.asongan.model.Item;
import com.lawencon.asongan.service.CategoryService;

public class CategoryImpl implements CategoryService{

	@Override
	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		List<Item> itemFruit = new ArrayList<>();
		List<Item> itemSayuran = new ArrayList<>();
		List<Item> itemMie = new ArrayList<>();
		List<Item> itemAir = new ArrayList<>();
		
		Item durian = new Item("Durian", 6000);
		itemFruit.add(durian);
		Item mangga = new Item("Mangga", 7000);
		itemFruit.add(mangga);
		Item apel = new Item("Apel", 8000);
		itemFruit.add(apel);
		Item nanas = new Item("Nanas", 9000);
		itemFruit.add(nanas);
		Category fruitCategory = new Category("Buah", itemFruit);
		
		list.add(fruitCategory);
		
		
		Item bayam  = new Item("Bayam", 6000);
		itemSayuran.add(bayam);
		Item brokoli = new Item("Brokoli", 7000);
		itemSayuran.add(brokoli);
		Item kol = new Item("Kol", 8000);
		itemSayuran.add(kol);
		Category sayuranCategory = new Category("Sayuran", itemSayuran);
		
		list.add(sayuranCategory);
		
		Item indomie  = new Item("Indomie", 6000);
		itemMie.add(indomie);
		Item mieSedap = new Item("Mie Sedap", 7000);
		itemMie.add(mieSedap);
		Item sarimi = new Item("Sarimi", 8000);
		itemMie.add(sarimi);
		
		Category mieCategory = new Category("Mie", itemMie);
		
		list.add(mieCategory);
		
		Item aqua  = new Item("Aqua", 6000);
		itemAir.add(aqua);
		Item lemineral = new Item("Le Mineral", 7000);
		itemAir.add(lemineral);
		Item danone = new Item("Danone", 8000);
		itemAir.add(danone);
		
		Category airCategory = new Category("Air", itemAir);
		
		list.add(airCategory);
		
		return list;
	}

}
