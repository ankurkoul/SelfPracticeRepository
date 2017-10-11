package com.foodkhana.repos;

import java.util.List;

import com.foodkhana.domain.Category;
import com.foodkhana.domain.Product;

public interface ICategoryRepo {
	void save(Category category);
	void update(Category category);
	void delete(Long category);
	Category find(Long categoryId);
	List<Category> getAllCategories();
	 List<Product>getCategoryProduct(Long id);
}
