package com.foodkhana.implementations.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.foodkhana.domain.ProductImages;
import com.foodkhana.repos.IProductImagesRepo;
import com.foodkhana.utilities.FoodKhanaHibernateDaoSupport;
@Repository
public class ProductImagesRepoImpl extends FoodKhanaHibernateDaoSupport implements IProductImagesRepo{
	public void save(ProductImages ProductImages){
		getHibernateTemplate().save(ProductImages);
	}

	public void update(ProductImages ProductImages){
		getHibernateTemplate().update(ProductImages);
	}

	public void delete(ProductImages ProductImages){
		getHibernateTemplate().delete(ProductImages);
	}

	public ProductImages findByProductImagesCode(String ProductImagesCode){
		List list = getHibernateTemplate().find(
                     "from ProductImages where ProductImagesCode=?",ProductImagesCode
                );
		return (ProductImages)list.get(0);
	}

	@Override
	public ProductImages find(String productImagesId) {
		return getHibernateTemplate().load(ProductImages.class, productImagesId);
	}
}
