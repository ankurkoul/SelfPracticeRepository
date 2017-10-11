package com.foodkhana.web.assemblers;

import org.springframework.stereotype.Component;

import com.foodkhana.domain.AdminUser;
import com.foodkhana.web.pojos.UserPOJO;

@Component
public class AdminUserAssembler {
	
	public UserPOJO fromEntityToPojo(AdminUser entity){
		UserPOJO pojo=new UserPOJO();
		pojo.setId(entity.getId());
		pojo.setPassword(entity.getPassword());

		pojo.setUserName(entity.getUserName());
		return pojo;
	}
	
	public AdminUser fromPojoToEntity(UserPOJO pojo){
		AdminUser entity=new AdminUser();
		entity.setId(pojo.getId());
		entity.setPassword(pojo.getPassword());
		entity.setUserName(pojo.getUserName());
	
		return entity;
	}
	
}
