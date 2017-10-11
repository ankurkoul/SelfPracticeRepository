package com.foodkhana.web.assemblers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foodkhana.domain.Address;
import com.foodkhana.domain.User;
import com.foodkhana.utilities.NullGuard;
import com.foodkhana.web.pojos.AddressPOJO;
import com.foodkhana.web.pojos.UserPOJO;

@Component
public class UserAssembler {
	
	@Autowired
	AddressAssembler addAssembler;
	
	public UserPOJO fromEntityToPojo(User entity){
		UserPOJO pojo=new UserPOJO();
		pojo.setId(entity.getId());
		pojo.setEmail(entity.getEmail());
		pojo.setPassword(entity.getPassword());
		List<AddressPOJO>addList=new ArrayList<>();
		for(Address  add:NullGuard.forList(entity.getAddressList())){
			addList.add(addAssembler.fromEntityToPojo(add));
		}
		pojo.setAddressList(addList);
		pojo.setUserName(entity.getUserName());
		return pojo;
	}
	
	public User fromPojoToEntity(UserPOJO pojo){
		User entity=new User();
		entity.setId(pojo.getId());
		entity.setEmail(pojo.getEmail());
		entity.setPassword(pojo.getPassword());
		List<Address>addList=new ArrayList<>();
		for(AddressPOJO  add:NullGuard.forList((pojo.getAddressList()))){
			addList.add(addAssembler.fromPojoToEntity(add));
		}
		entity.setAddressList(addList);

		entity.setRole(pojo.getRole());
		entity.setUserName(pojo.getUserName());
	
		return entity;
	}
	
}
