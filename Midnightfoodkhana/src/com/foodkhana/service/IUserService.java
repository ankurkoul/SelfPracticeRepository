package com.foodkhana.service;

import java.util.List;

import com.foodkhana.domain.User;

public interface IUserService {

	void save(User user);

	void update(User user);

	void delete(Long user);

	User find(String userCode);

	User getUser(String username, String password);

	List<User> findUsers();

}
