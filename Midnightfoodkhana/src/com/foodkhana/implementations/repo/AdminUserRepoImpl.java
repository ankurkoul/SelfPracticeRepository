package com.foodkhana.implementations.repo;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.foodkhana.domain.AdminUser;
import com.foodkhana.domain.User;
import com.foodkhana.repos.IAdminUserRepo;
import com.foodkhana.utilities.FoodKhanaHibernateDaoSupport;

@Repository
public class AdminUserRepoImpl extends FoodKhanaHibernateDaoSupport implements
		IAdminUserRepo {

	@Override
	public void save(AdminUser User) {
		getHibernateTemplate().save(User);
	}

	@Override
	public void update(AdminUser User) {
		getHibernateTemplate().update(User);
	}

	@Override
	public void delete(Long userId) {
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		AdminUser user = (AdminUser) session.load(AdminUser.class, userId);
		session.delete(user);
		session.flush();
	}

	public User findByUserId(String UserId) {
		List list = getHibernateTemplate().find(
				"from AdminUser where AdminUser.id=?", UserId);
		return (User) list.get(0);
	}

	@Override
	public AdminUser find(String id) {

		return getHibernateTemplate().load(AdminUser.class, id);
	}

	@Override
	public AdminUser getUser(String username, String password) {

		String[] params = new String[2];
		params[0] = username;
		params[1] = password;
		List info = getHibernateTemplate().find(
				"from AdminUser u where u.userName = ? and u.password = ?",
				params);
		if (!info.isEmpty()) {
			return (AdminUser) info.get(0);
		} else
			return null;
	}

	@Override
	public List<AdminUser> findUsers() {
		List<?> empList = getHibernateTemplate().find("from AdminUser ");

		if (!empList.isEmpty())
			return (List<AdminUser>) empList;
		else
			return Collections.emptyList();
	}

}
