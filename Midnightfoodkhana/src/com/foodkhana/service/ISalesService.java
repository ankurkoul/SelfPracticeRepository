package com.foodkhana.service;

import com.foodkhana.domain.Sales;


public interface ISalesService {
	void save(Sales sales);
	void update(Sales sales);
	void delete(Sales sales);
	Sales find(String salesCode);

}
