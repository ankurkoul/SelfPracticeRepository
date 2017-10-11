package com.foodkhana.web.assemblers;

import org.springframework.stereotype.Component;

import com.foodkhana.domain.Address;
import com.foodkhana.web.pojos.AddressPOJO;

@Component
public class AddressAssembler {

	public AddressPOJO fromEntityToPojo(Address entity) {
		AddressPOJO addPojo = new AddressPOJO();
		addPojo.setId(entity.getId());
		addPojo.setLocal(entity.getLocal());
		addPojo.setPincode(entity.getPincode());
		addPojo.setDistrict(entity.getDistrict());
		addPojo.setState(entity.getState());
		return addPojo;
	}

	public Address fromPojoToEntity(AddressPOJO pojo) {
		Address entity = new Address();
		entity.setId(pojo.getId());
		entity.setLocal(pojo.getLocal());
		entity.setPincode(pojo.getPincode());
		entity.setDistrict(pojo.getDistrict());
		entity.setState(pojo.getState());
		return entity;
	}

}
