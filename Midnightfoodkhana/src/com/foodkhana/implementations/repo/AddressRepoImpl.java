package com.foodkhana.implementations.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.foodkhana.domain.Address;
import com.foodkhana.repos.IAddressRepo;
import com.foodkhana.utilities.FoodKhanaHibernateDaoSupport;
@Repository
public class AddressRepoImpl extends FoodKhanaHibernateDaoSupport implements IAddressRepo{
	public void save(Address add){
		getHibernateTemplate().save(add);
	}

	public void update(Address add){
		getHibernateTemplate().update(add);
	}

	public void delete(Address add){
		getHibernateTemplate().delete(add);
	}

/*	public Product findByProductCode(String ProductCode){
		List list = getHibernateTemplate().find(
                     "from Product where ProductCode=?",ProductCode
                );
		return (Product)list.get(0);
	}
*/
	@Override
	public Address find(String addId) {
		return getHibernateTemplate().load(Address.class,addId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAll(){
		
		List<Address>pList=(List<Address>) getHibernateTemplate().find("from Address");
		     
               
		return pList;
	}

	


}
