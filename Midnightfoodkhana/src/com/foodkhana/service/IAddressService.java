package com.foodkhana.service;

import java.util.List;

import com.foodkhana.domain.Address;

public interface IAddressService {


	void save(Address address);
	void update(Address address);
	void delete(Address address);
	Address find(String addressId);
	List<Address> findAll();

}
