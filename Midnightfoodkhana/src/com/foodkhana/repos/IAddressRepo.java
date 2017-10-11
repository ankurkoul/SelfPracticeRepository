package com.foodkhana.repos;

import java.util.List;

import com.foodkhana.domain.Address;

public interface IAddressRepo {


	void save(Address add);
	void update(Address add);
	void delete(Address add);
	Address find(String addId);
	List<Address> findAll();

}
