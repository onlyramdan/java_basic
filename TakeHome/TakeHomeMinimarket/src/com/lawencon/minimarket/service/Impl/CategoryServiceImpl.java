package com.lawencon.minimarket.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private List<Category> categoryList = new ArrayList<>();

	@Override
	public Category addCategories(String category) {
		Category existCategory= byName(category);
		if(existCategory != null ) {
			return existCategory;
		}
		Category newCategory = new Category();
		newCategory.setName(category);
        categoryList.add(newCategory);
        return newCategory;
	}

	@Override
	public List<Category> getAll() {
		if(categoryList.size() == 0) {
			System.out.println("Belum ada Kategori !!!");
		}
		return categoryList;
	}
	
	private Category byName(String name){
		 for (Category category : categoryList) {
	            if (category.getName().equalsIgnoreCase(name)) {
	                return category;
	            }
	        }
	        return null;
	}

	@Override
	public String getCategory(int index) {
		String category = categoryList.get(index).getName();
		return category;
	}
}
