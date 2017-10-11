package com.foodkhana.service;

import java.util.List;

import com.foodkhana.domain.Category;
import com.foodkhana.domain.Product;

public interface IProductService {

	void save(Product product);
	void update(Product product);
	void delete(Product product);
	Product find(Long productCode);
	 List<Product> findAll();
	 List<Product> findByCategory(Long id);

}
