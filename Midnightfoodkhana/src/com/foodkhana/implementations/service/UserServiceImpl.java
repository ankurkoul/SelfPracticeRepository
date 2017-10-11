package com.foodkhana.implementations.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodkhana.domain.User;
import com.foodkhana.repos.IUserRepo;
import com.foodkhana.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepo userRepo;

	@Transactional(readOnly = false)
	public void save(User User) {
		userRepo.save(User);
	}

	public void update(User User) {
		userRepo.update(User);
	}
	@Transactional(readOnly = false)
	public void delete(Long id) {
		userRepo.delete(id);
	}
	@Transactional(readOnly=true)
	public User find(String UserCode) {
		return userRepo.find(UserCode);
	}

	@Override
	@Transactional(readOnly=true)  
	public User getUser(String username, String password) {
		User user=userRepo.getUser(username, password);
		if(user!=null){
			
			Hibernate.initialize(user.getAddressList());
			Hibernate.initialize(user.getPhoneNo());
		}
		return user;
	}
	@Transactional(readOnly=false)
    public void deleteUser(List<?> userList) {        
      userRepo.deleteUser(userList);
    }

	@Override
	 @Transactional(readOnly=true)
	public List<User> findUsers() {
		// TODO Auto-generated method stub
		return userRepo.findUsers();
	}
}
