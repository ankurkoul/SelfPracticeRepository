package com.foodkhana.implementations.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodkhana.domain.Product;
import com.foodkhana.domain.User;
import com.foodkhana.domain.UserOrder;
import com.foodkhana.repos.IUserOrderRepo;
import com.foodkhana.service.IUserOrderService;

@Service
public class UserOrderServiceImpl implements IUserOrderService{
	@Autowired
	IUserOrderRepo userOrderRepo;

	public void setIUserOrderRepo(IUserOrderRepo userOrderRepo) {
		this.userOrderRepo = userOrderRepo;
	}
	@Transactional(readOnly = false)
	public void save(UserOrder UserOrder){
		userOrderRepo.save(UserOrder);
		
	}
	@Transactional(readOnly = false)
	public void update(UserOrder UserOrder){
		userOrderRepo.update(UserOrder);
	}

	public void delete(UserOrder UserOrder){
		userOrderRepo.delete(UserOrder);
	}

	public List<UserOrder> find(){
		return userOrderRepo.find();
	}

	@Override
	@Transactional(readOnly = false)
	public List<UserOrder> findForUser(String username, String password) {
		List<UserOrder> order=userOrderRepo.findForUser(username, password);
		
		return order;
	}

	@Override
	public List<Product> getOrderProduct(Long id) {
		List<Product> p=userOrderRepo. getOrderProduct(id);
		return p;
	}
}
