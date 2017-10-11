package com.foodkhana.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.foodkhana.domain.User;
import com.foodkhana.service.IUserService;

public class Tester {

	public static void main( String[] args )
    {
    	ApplicationContext appContext =
    	  new ClassPathXmlApplicationContext("config/BeanLocations.xml");

    	IUserService userService=	appContext.getBean(IUserService.class);
    	/*User user=appContext.getBean(User.class);
    	user.setUserName("ankur");
    	user.setEmail("ankur@gmail.com");
    	userService.save(user);*/
    User user1=userService.getUser("abcd", "abcd");
    System.out.println(user1);
    
    	 /*List info=getHibernateTemplate().find("from User u where u.userName = ? and u.password = ?",params);		
 		if(!info.isEmpty()){
 			return (User)info.get(0);
 		}else
 			return null;*/
    	/*StockBo stockBo = (StockBo)appContext.getBean("stockBo");

    	*//** insert **//*
    	Stock stock = new Stock();
    	stock.setStockCode("7668");
    	stock.setStockName("HAIO");
    	stockBo.save(stock);

    	*//** select **//*
    	Stock stock2 = stockBo.findByStockCode("7668");
    	System.out.println(stock2);

    	*//** update **//*
    	stock2.setStockName("HAIO-1");
    	stockBo.update(stock2);

    	*//** delete **//*
    	stockBo.delete(stock2);
*/
    	System.out.println("Done");
    }
}
