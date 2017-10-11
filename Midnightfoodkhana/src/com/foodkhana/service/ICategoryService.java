package com.foodkhana.service;

import java.util.List;

import com.foodkhana.domain.Category;
import com.foodkhana.domain.Product;

public interface ICategoryService {

	void save(Category category);
	void update(Category category);
	void delete(Long catId);
	Category find(Long catId);
	List<Category> getAllCategories();
	 List<Product>getCategoryProduct(Long id);

}
