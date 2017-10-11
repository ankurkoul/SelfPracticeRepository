package com.foodkhana.implementations.repo;

import java.util.Collections;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.foodkhana.domain.Product;
import com.foodkhana.domain.User;
import com.foodkhana.domain.UserOrder;
import com.foodkhana.repos.IUserOrderRepo;
import com.foodkhana.utilities.FoodKhanaHibernateDaoSupport;

@Repository
public class UserOrderRepoImpl extends FoodKhanaHibernateDaoSupport implements
		IUserOrderRepo {

	public void save(UserOrder UserOrder) {
		getHibernateTemplate().save(UserOrder);
	/*SessionFactory sf=	getHibernateTemplate().getSessionFactory();
	if(sf!=null){
		sf.openSession().flush();
	}*/
	
	}

	public void update(UserOrder UserOrder) {
		getHibernateTemplate().update(UserOrder);
	}

	public void delete(UserOrder UserOrder) {
		getHibernateTemplate().delete(UserOrder);
	}

	public UserOrder findByUserOrderCode(String UserOrderCode) {
		List list = getHibernateTemplate().find(
				"from UserOrder where UserOrderCode=?", UserOrderCode);
		return (UserOrder) list.get(0);
	}

	@Override
	public List<UserOrder> find() {

		List<UserOrder> list = (List<UserOrder>) getHibernateTemplate().find(
				"from UserOrder");
		return list;
	}

	@Override
	public List<UserOrder> findForUser(String username, String password) {
		User user = null;
		String[] params = new String[2];
		params[0] = username;
		params[1] = password;
		List info = getHibernateTemplate().find(
				"from User u where u.userName = ? and u.password = ?", params);
		if (!info.isEmpty()) {
			user = (User) info.get(0);
			List<UserOrder> list = (List<UserOrder>) getHibernateTemplate().find(
					"from UserOrder o where o.user=?", user);
			for(UserOrder o:list){
				Hibernate.initialize(o.getProduct());
			}
			//Hibernate.initialize(user.getAddressList());
			//ibernate.initialize(user.getPhoneNo());
			return list;
		}
		return null;

	}

	@Override
	public List<Product> getOrderProduct(Long id) {
		UserOrder order = getHibernateTemplate().load(UserOrder.class, id);
		List<Product> pList=	order.getProduct();
		if(!pList.isEmpty()){
			return pList;
		}else{
			
			return Collections.emptyList();
		}
	}

}
