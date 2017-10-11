package com.foodkhana.implementations.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodkhana.domain.Category;
import com.foodkhana.domain.Product;
import com.foodkhana.domain.Vendor;
import com.foodkhana.repos.IProductRepo;
import com.foodkhana.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductRepo iProductRepo;

	public void setIProductRepo(IProductRepo IProductRepo) {
		this.iProductRepo = IProductRepo;
	}

	@Transactional(readOnly=false)  
	public void save(Product Product){
		iProductRepo.save(Product);
	}

	public void update(Product Product){
		iProductRepo.update(Product);
	}

	public void delete(Product Product){
		iProductRepo.delete(Product);
	}

	@Transactional
	public Product find(Long ProductCode){
		Product p=iProductRepo.find(ProductCode);
/*if(p!=null){
			
			Hibernate.initialize(p.getCategory());
			Hibernate.initialize(p.getVendor());
		}*/
		
		Category cat=p.getCategory();
		Vendor v=p.getVendor();
		
		return p;
	}

	@Override
	@Transactional(readOnly=true)  
	public List<Product> findAll() {
	
		return iProductRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)  
	public List<Product> findByCategory(Long id) {
		return iProductRepo.findByCategory(id);
	}
}
