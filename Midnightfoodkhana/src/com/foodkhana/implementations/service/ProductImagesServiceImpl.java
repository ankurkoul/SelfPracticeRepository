package com.foodkhana.implementations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodkhana.domain.ProductImages;
import com.foodkhana.repos.IProductImagesRepo;
import com.foodkhana.service.IProductImagesService;

@Service
public class ProductImagesServiceImpl implements IProductImagesService {

	
	@Autowired
	IProductImagesRepo IProductImagesRepo;

	public void setIProductImagesRepo(IProductImagesRepo IProductImagesRepo) {
		this.IProductImagesRepo = IProductImagesRepo;
	}

	public void save(ProductImages ProductImages){
		IProductImagesRepo.save(ProductImages);
	}

	public void update(ProductImages ProductImages){
		IProductImagesRepo.update(ProductImages);
	}

	public void delete(ProductImages ProductImages){
		IProductImagesRepo.delete(ProductImages);
	}

	public ProductImages find(String ProductImagesCode){
		return IProductImagesRepo.find(ProductImagesCode);
	}
}
