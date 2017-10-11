package com.foodkhana.repos;

import com.foodkhana.domain.ProductImages;

public interface IProductImagesRepo {

	void save(ProductImages productImages);
	void update(ProductImages productImages);
	void delete(ProductImages productImages);
	ProductImages find(String productImagesId);
}
