package com.foodkhana.repos;

import java.util.List;

import com.foodkhana.domain.User;

public interface IUserRepo {

	void save(User user);

	void update(User user);

	void delete(Long userId);

	User find(String id);

	User getUser(String username, String password);

	void deleteUser(List<?> userList);

	List<User> findUsers();
}
