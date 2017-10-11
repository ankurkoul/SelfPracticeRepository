package com.foodkhana.implementations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodkhana.domain.Category;
import com.foodkhana.domain.Product;
import com.foodkhana.repos.ICategoryRepo;
import com.foodkhana.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	ICategoryRepo categoryRepo;

	public void setICategoryRepo(ICategoryRepo ICategoryRepo) {
		this.categoryRepo = ICategoryRepo;
	}

	public void save(Category Category){
		categoryRepo.save(Category);
	}

	public void update(Category Category){
		categoryRepo.update(Category);
	}

	public void delete(Long catId){
		categoryRepo.delete(catId);
	}

	public Category find(Long CategoryCode){
		return categoryRepo.find(CategoryCode);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.getAllCategories();
	}

	public List<Product>getCategoryProduct(Long id){
		
		return categoryRepo.getCategoryProduct(id);
			
	}
	

	
}
