package com.foodkhana.repos;

import java.util.Date;

import com.foodkhana.domain.UserPayment;

public interface IUserPaymentRepo {

	void save(UserPayment userPayment);
	void update(UserPayment userPayment);
	void delete(UserPayment userPayment);
	UserPayment find(String userPaymentId);
	UserPayment validate(String cardHolderName,String cardType,String securityCode,String paymentType);

}
