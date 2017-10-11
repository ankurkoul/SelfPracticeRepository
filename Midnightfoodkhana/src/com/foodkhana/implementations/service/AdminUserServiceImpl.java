package com.foodkhana.implementations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodkhana.domain.AdminUser;
import com.foodkhana.repos.IAdminUserRepo;
import com.foodkhana.service.IAdminUserService;

@Service
public class AdminUserServiceImpl implements IAdminUserService {

	@Autowired
	IAdminUserRepo adminUserRepo;

	@Transactional(readOnly = false)
	public void save(AdminUser User) {
		adminUserRepo.save(User);
	}

	public void update(AdminUser User) {
		adminUserRepo.update(User);
	}
	@Transactional(readOnly=true)
	public AdminUser find(String UserCode) {
		return adminUserRepo.find(UserCode);
	}
		@Override
	@Transactional(readOnly=true)  
	public AdminUser getUser(String username, String password) {
		// TODO Auto-generated method stub
		return adminUserRepo.getUser(username, password);
	}
/*
		@Transactional(readOnly = false)
		public void delete(Long id) {
			adminUserRepo.delete(id);
		}
	@Transactional(readOnly=false)
    public void deleteUser(List<?> userList) {        
      adminUserRepo.delete(userList);
    }

	@Override
	 @Transactional(readOnly=true)
	public List<AdminUser> findUsers() {
		// TODO Auto-generated method stub
		
	}*/

		@Override
		public void delete(Long userId) {
			adminUserRepo.delete(userId);
			
		}

		@Override
		public List<AdminUser> findUsers() {
			// TODO Auto-generated method stub
			 return adminUserRepo.findUsers();
		}
}
