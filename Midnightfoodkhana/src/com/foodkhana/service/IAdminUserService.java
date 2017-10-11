package com.foodkhana.service;

import java.util.List;

import com.foodkhana.domain.AdminUser;

public interface IAdminUserService {

	void save(AdminUser user);

	void update(AdminUser user);

	void delete(Long user);

	AdminUser find(String userCode);

	AdminUser getUser(String username, String password);

	List<AdminUser> findUsers();

}
