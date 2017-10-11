package com.foodkhana.implementations.repo;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.foodkhana.domain.Category;
import com.foodkhana.domain.Product;
import com.foodkhana.repos.ICategoryRepo;
import com.foodkhana.utilities.FoodKhanaHibernateDaoSupport;
@Repository
public class CategoryRepoImpl extends FoodKhanaHibernateDaoSupport implements ICategoryRepo  {
	
	public void save(Category Category){
		getHibernateTemplate().save(Category);
	}

	public void update(Category Category){
		getHibernateTemplate().update(Category);
	}

	public void delete(Long catId){
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Category cat = (Category)session.load(Category.class,catId);
	    session.delete(cat);
	    session.flush() ;
	}

	public Category findByCategoryCode(String CategoryCode){
		List list = getHibernateTemplate().find(
                     "from Category where CategoryCode=?",CategoryCode
                );
		return (Category)list.get(0);
	}

	@Override
	public Category find(Long categoryId) {
	return getHibernateTemplate().load(Category.class, categoryId);
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> list = (List<Category>) getHibernateTemplate().find( "from Category "   );
		return list;
	}

	@Override
	public List<Product> getCategoryProduct(Long id) {
		List<Product> list = (List<Product>) getHibernateTemplate().find( "from Product p where p.category.id = ? ",id   );
		return list;
	}
	
}
