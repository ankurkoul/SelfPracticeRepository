package com.foodkhana.repos;

import java.util.List;

import com.foodkhana.domain.Vendor;

public interface IVendorRepo {


	void save(Vendor product);
	void update(Vendor product);
	public void delete(Long userId);
	Vendor find(String productId);
	List<Vendor> findAll();
	void deleteVendor(List<?> vendorList);
	
}
