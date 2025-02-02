package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Item;

public interface ItemService {
	Item addItem(Item item);
	Item getItem(int index);
	List<Item> getAll();
	void deleteOneItem(int index);
	Item updateItem(int index, Item item);
	void getItemByCategory(String category);
	Boolean getQtyItemAndStock(int index, int qty);
	void addQtyByName(int qty, String name);
	Boolean getQtyItemAndStockCategory(int indexitemcategory, int qty , String category);
	Item getItemCategory(int indexitemcategory,String category);
	Boolean deleteQtyName(int qty, String name);
}
