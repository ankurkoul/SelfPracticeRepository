package com.foodkhana.repos;

import java.util.List;

import com.foodkhana.domain.AdminUser;

public interface IAdminUserRepo {

	void save(AdminUser user);
	void update(AdminUser user);
	void delete(Long userId);
	AdminUser find(String id);
	AdminUser getUser(String username,String password);
	 List<AdminUser> findUsers();
}

