package com.foodkhana.implementations.repo;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.foodkhana.domain.User;
import com.foodkhana.repos.IUserRepo;
import com.foodkhana.utilities.FoodKhanaHibernateDaoSupport;

@Repository
public class UserRepoImpl extends FoodKhanaHibernateDaoSupport implements IUserRepo {

	@Override
	public void  save(User user){
	 getHibernateTemplate().save(user);
	}
	@Override
	public void update(User user){
		getHibernateTemplate().update(user);
	}
	@Override
	public void delete(Long userId){
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		User user = (User)session.load(User.class,userId);
	    session.delete(user);
	    session.flush() ;
	//	getHibernateTemplate().delete(user);
	}
	
	public User findByUserId(String userId){
		List list = getHibernateTemplate().find(
                     "from User where id=?",userId
                );
		return (User)list.get(0);
	}

	@Override
	public User find(String id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().load(User.class, id);
	}

	@Override
	public User getUser(String username, String password) {
		
		
		/*
		  String[] col=new String[2];
    col[0]=col1;
    col[1]=col2;
    List info=this.getHibernateTemplate().find("from Test.ExampleDao where col1=? and col2=?",col);		
    if (info.size()>0){
      for (int i=0;i<info.size();i++) {
          Example ex = (Example)info.get(i);
           System.out.println("col1: "+ex.getCol1()+" col2: "+ex.getCol2()+" col3: "+ex.getCol3());
      }
    }
		 
		 */
	//	List list = getHibernateTemplate().find("from User where User.userName = "+username+" and User.password = "+password
      
	//);
	//return (User)list.get(0);
		
		 String[] params=new String[2];
		 params[0]=username;
		 params[1]=password;
		 List info=getHibernateTemplate().find("from User u where u.userName = ? and u.password = ?",params);		
		if(!info.isEmpty()){
			return (User)info.get(0);
		}else
			return null;
		
/*		
		List info = getHibernateTemplate().find("from User u where u.userName = "+username+" and u.password = "+password);
		if(!info.isEmpty()){
			return (User)info.get(0);
		}else
			return null;*/
	}
	
	@Override
	  public void deleteUser(List<?> userList) {        
	        if (!userList.isEmpty()) {
	            getHibernateTemplate().deleteAll(userList);
	        }
	    }
	@Override
	public List<User> findUsers() {
		 List<?> empList = getHibernateTemplate().find("from User ");
	     //   System.out.println("Employees found: " + empList.size());
		 if(!empList.isEmpty())
	        return (List<User>) empList;
		 else
			 return Collections.emptyList();
	}
	
	
}
