package com.foodkhana.repos;

import java.util.List;

import com.foodkhana.domain.Product;
import com.foodkhana.domain.UserOrder;

public interface IUserOrderRepo {

	void save(UserOrder userOrder);
	void update(UserOrder userOrder);
	void delete(UserOrder userOrder);
	List<UserOrder> find();
	List<UserOrder> findForUser(String username, String password);
	List<Product> getOrderProduct(Long id);
}
