package com.foodkhana.implementations.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.foodkhana.domain.Product;
import com.foodkhana.repos.IProductRepo;
import com.foodkhana.utilities.FoodKhanaHibernateDaoSupport;
@Repository
public class ProductRepoImpl extends FoodKhanaHibernateDaoSupport implements IProductRepo{
	public void save(Product Product){
		getHibernateTemplate().save(Product);
	}

	public void update(Product Product){
		getHibernateTemplate().update(Product);
	}

	public void delete(Product Product){
		getHibernateTemplate().delete(Product);
	}

/*	public Product findByProductCode(String ProductCode){
		List list = getHibernateTemplate().find(
                     "from Product where ProductCode=?",ProductCode
                );
		return (Product)list.get(0);
	}
*/
	@Override
	public Product find(Long productId) {
		return getHibernateTemplate().load(Product.class,productId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll(){
		
		List<Product>pList=(List<Product>) getHibernateTemplate().find("from Product");
		     
               
		return pList;
	}

	@Override
	public List<Product> findByCategory(Long id) {
		List<Product>pList=(List<Product>) getHibernateTemplate().find("from Product p , p.category c where c.id = "+id);
	       
		return pList;
	}
	
	
}
