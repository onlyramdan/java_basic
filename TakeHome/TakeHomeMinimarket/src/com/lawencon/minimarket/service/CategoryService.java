package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Category;

public interface CategoryService {
	Category addCategories(String category);
	List<Category> getAll();
	String getCategory(int index);
}
