package com.foodkhana.implementations.repo;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.foodkhana.domain.User;
import com.foodkhana.domain.Vendor;
import com.foodkhana.repos.IVendorRepo;
import com.foodkhana.utilities.FoodKhanaHibernateDaoSupport;
@Repository
public class VendorRepoImpl extends FoodKhanaHibernateDaoSupport implements IVendorRepo{
	public void save(Vendor Vendor){
		getHibernateTemplate().save(Vendor);
	}

	public void update(Vendor Vendor){
		getHibernateTemplate().update(Vendor);
	}

	@Override
	public void delete(Long userId){
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Vendor vendor = (Vendor)session.load(Vendor.class,userId);
	    session.delete(vendor);
	    session.flush() ;
	//	getHibernateTemplate().delete(user);
	}

/*	public Vendor findByVendorCode(String VendorCode){
		List list = getHibernateTemplate().find(
                     "from Vendor where VendorCode=?",VendorCode
                );
		return (Vendor)list.get(0);
	}
*/
	@Override
	public Vendor find(String vendorId) {
		return getHibernateTemplate().load(Vendor.class,vendorId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Vendor> findAll(){
		
		
		 List<?> pList=(List<Vendor>) getHibernateTemplate().find("from Vendor");
	     //   System.out.println("Employees found: " + empList.size());
		 if(!pList.isEmpty())
	        return (List<Vendor>) pList;
		 else
			 return Collections.emptyList();     
               

	}

	
	public User findByVendorId(String userId){
		List list = getHibernateTemplate().find(
                     "from User where id=?",userId
                );
		return (User)list.get(0);
	}

	
	@Override
	  public void deleteVendor(List<?> userList) {        
	        if (!userList.isEmpty()) {
	            getHibernateTemplate().deleteAll(userList);
	        }
	    }
	
	
	
}
