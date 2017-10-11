package com.foodkhana.implementations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodkhana.domain.Address;
import com.foodkhana.repos.IAddressRepo;
import com.foodkhana.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressRepo iAddressRepo;

	public void setIAddressRepo(IAddressRepo IAddressRepo) {
		this.iAddressRepo = IAddressRepo;
	}

	public void save(Address Address){
		iAddressRepo.save(Address);
	}

	public void update(Address Address){
		iAddressRepo.update(Address);
	}

	public void delete(Address Address){
		iAddressRepo.delete(Address);
	}

	public Address find(String AddressCode){
		return iAddressRepo.find(AddressCode);
	}

	@Override
	public List<Address> findAll() {
	
		return iAddressRepo.findAll();
	}


}
