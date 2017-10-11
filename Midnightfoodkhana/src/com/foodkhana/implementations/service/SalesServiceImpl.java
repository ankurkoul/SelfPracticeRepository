package com.foodkhana.implementations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodkhana.domain.Sales;
import com.foodkhana.repos.ISalesRepo;
import com.foodkhana.service.ISalesService;

@Service
public class SalesServiceImpl implements ISalesService {

	@Autowired
	ISalesRepo ISalesRepo;

	public void setISalesRepo(ISalesRepo ISalesRepo) {
		this.ISalesRepo = ISalesRepo;
	}

	public void save(Sales Sales){
		ISalesRepo.save(Sales);
	}

	public void update(Sales Sales){
		ISalesRepo.update(Sales);
	}

	public void delete(Sales Sales){
		ISalesRepo.delete(Sales);
	}

	public Sales find(String SalesCode){
		return ISalesRepo.find(SalesCode);
	}
}
