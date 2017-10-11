package com.foodkhana.service;

import java.util.List;

import com.foodkhana.domain.Vendor;

public interface IVendorService {


	void save(Vendor vendor);
	void update(Vendor vendor);
	void delete(Long vendor);
	Vendor find(String vendorId);
	List<Vendor> findAll();
	// List<Vendor> findByCategory(Long id);
}
