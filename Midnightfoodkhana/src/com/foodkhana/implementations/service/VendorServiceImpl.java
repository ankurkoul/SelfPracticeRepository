package com.foodkhana.implementations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodkhana.domain.User;
import com.foodkhana.domain.Vendor;
import com.foodkhana.repos.IVendorRepo;
import com.foodkhana.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {


	@Autowired
	IVendorRepo vendorRepo;

	@Transactional(readOnly = false)
	public void save(Vendor vendor) {
		vendorRepo.save(vendor);
	}

	public void update(Vendor vendor) {
		vendorRepo.update(vendor);
	}
	@Transactional(readOnly = false)
	public void delete(Long vendorId) {
		vendorRepo.delete(vendorId);
	}
	@Transactional(readOnly=true)
	public Vendor find(String UserCode) {
		return vendorRepo.find(UserCode);
	}

	@Transactional(readOnly=false)
    public void deleteVendor(List<?> vendorList) {        
      vendorRepo.deleteVendor(vendorList);
    }

	@Override
	 @Transactional(readOnly=true)
	public List<Vendor> findAll() {
		// TODO Auto-generated method stub
		return vendorRepo.findAll();
	}

	
	
}
