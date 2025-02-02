package com.lawencon.minimarket.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.service.ItemService;

public class ItemServiceImpl implements ItemService {
	private List<Item> itemList = new ArrayList<>();

	@Override
	public Item addItem(Item itemAdd) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getName().equals(itemAdd.getName())&& itemList.get(i).getCategory().getName().equals(itemAdd.getCategory().getName())) {
				int totalStock = itemList.get(i).getStock() + itemAdd.getStock();
				itemList.get(i).setStock(totalStock);
				itemList.get(i).setPrice(itemAdd.getPrice());
				return itemAdd;
			}
		}	
		itemList.add(itemAdd);
		return itemAdd;
	}

	@Override
	public Item getItem(int index) {
		return itemList.get(index);
	}

	@Override
	public List<Item> getAll() {
		if(itemList.size()==0) {
			System.out.println("Belum Ada Item");
		}
		return itemList;
	}

	@Override
	public void deleteOneItem(int index) {
		itemList.remove(index);
		System.out.println("Item Berhasil Dihapus");
	}

	@Override
	public Item updateItem(int index, Item item) {
		itemList.get(index).setCategory(item.getCategory());
		itemList.get(index).setName(item.getName());
		itemList.get(index).setPrice(item.getPrice());
		itemList.get(index).setStock(item.getStock());
		return itemList.get(index);
	}

	@Override
	public void getItemByCategory(String category) {
		int number = 1;
		for(Item items : itemList ) {
			if(items.getCategory().getName().equals(category)) {
				System.out.print(number+ "." + items.toStringList());
				number++;
			}
		}
		if(number == 1) {
			System.out.println("tidak item di kategori");
		}
	}

	@Override
	public Boolean getQtyItemAndStock(int index, int qty) {
		if(itemList.get(index).getStock()< qty) {
			return true;
		}
		return false;
	}

	@Override
	public void addQtyByName(int qty, String name) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getName().equals(name)) {
				int totalStock = itemList.get(i).getStock() + qty;
				itemList.get(i).setStock(totalStock);
			}
		}	
		
	}

	@Override
	public Boolean getQtyItemAndStockCategory(int indexitemcategory, int qty, String category) {
		int number = 1;
		for(Item items : itemList ) {
			if(items.getCategory().getName().equals(category)) {
				if(number == indexitemcategory){					
					if(items.getStock()<qty) {
						return true;
					}
				}
				number++;
			}
		}
		return false;
	}

	@Override
	public Item getItemCategory(int indexitemcategory, String category) {
		Item item = new Item();
		int number = 1;
		for(Item items : itemList ) {
			if(items.getCategory().getName().equals(category)) {
				if(number == indexitemcategory){					
					item = items;
				}
				number++;
			}
		}
		return item;
	}

	@Override
	public Boolean deleteQtyName(int qty, String name) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getName().equals(name)) {
				int totalStock = itemList.get(i).getStock() - qty;
				if(totalStock > 0) {
					itemList.get(i).setStock(totalStock);
					return true;
				}
			}
		}
		return false;
		
	}
}
