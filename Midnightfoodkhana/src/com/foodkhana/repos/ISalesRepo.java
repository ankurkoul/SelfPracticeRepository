package com.foodkhana.repos;

import com.foodkhana.domain.Sales;


public interface ISalesRepo {


	void save(Sales sales);
	void update(Sales sales);
	void delete(Sales sales);
	Sales find(String salesid);
}
