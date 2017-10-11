package com.foodkhana.service;

import com.foodkhana.domain.ProductImages;

public interface IProductImagesService {

	void save(ProductImages productImages);
	void update(ProductImages productImages);
	void delete(ProductImages productImages);
	ProductImages find(String productImagesCode);

}
