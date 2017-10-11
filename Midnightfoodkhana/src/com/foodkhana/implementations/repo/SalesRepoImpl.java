package com.foodkhana.implementations.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.foodkhana.domain.Sales;
import com.foodkhana.repos.ISalesRepo;
import com.foodkhana.utilities.FoodKhanaHibernateDaoSupport;
@Repository
public class SalesRepoImpl extends FoodKhanaHibernateDaoSupport implements ISalesRepo{

	public void save(Sales Sales){
		getHibernateTemplate().save(Sales);
	}

	public void update(Sales Sales){
		getHibernateTemplate().update(Sales);
	}

	public void delete(Sales Sales){
		getHibernateTemplate().delete(Sales);
	}

	public Sales findBySalesCode(String SalesCode){
		List list = getHibernateTemplate().find(
                     "from Sales where SalesCode=?",SalesCode
                );
		return (Sales)list.get(0);
	}


	@Override
	public Sales find(String id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().load(Sales.class, id);
	}
}
