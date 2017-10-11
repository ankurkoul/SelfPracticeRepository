package com.foodkhana.implementations.repo;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.foodkhana.domain.User;
import com.foodkhana.domain.UserPayment;
import com.foodkhana.repos.IUserPaymentRepo;
import com.foodkhana.utilities.FoodKhanaHibernateDaoSupport;
@Repository
public class UserPaymentRepoImpl extends FoodKhanaHibernateDaoSupport implements IUserPaymentRepo {
	public void save(UserPayment UserPayment){
		getHibernateTemplate().save(UserPayment);
	}

	public void update(UserPayment UserPayment){
		getHibernateTemplate().update(UserPayment);
	}

	public void delete(UserPayment UserPayment){
		getHibernateTemplate().delete(UserPayment);
	}

	public UserPayment findByUserPaymentCode(String UserPaymentCode){
		List list = getHibernateTemplate().find(
                     "from UserPayment where UserPaymentCode=?",UserPaymentCode
                );
		return (UserPayment)list.get(0);
	}

	@Override
	public UserPayment find(String userPaymentId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().load(UserPayment.class, userPaymentId);
	}
//String cardHolderName,String cardType,Date expiryDate,String securityCode,String paymentType
	@Override
	public UserPayment validate(String cardHolderName, String cardType,
			 String securityCode, String paymentType) {
		List<UserPayment> list = (List<UserPayment>) getHibernateTemplate().find(
                "from UserPayment up where up.cardHolderName = "+ cardHolderName +
                "and up.cardType = "+cardType +
                " and up.securityCode	= "+securityCode+
                " and up.paymentType ="+paymentType);
	return (UserPayment)list.get(0);
		
	}
}
