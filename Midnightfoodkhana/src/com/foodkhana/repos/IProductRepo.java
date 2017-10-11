package com.foodkhana.repos;

import java.util.List;

import com.foodkhana.domain.Product;

public interface IProductRepo {


	void save(Product product);
	void update(Product product);
	void delete(Product product);
	Product find(Long productId);
	List<Product> findAll();
	 List<Product> findByCategory(Long id);
}
