package com.foodkhana.service;

import java.util.Date;

import com.foodkhana.domain.User;
import com.foodkhana.domain.UserPayment;

public interface IUserPaymentService {
	void save(UserPayment userPayment);
	void update(UserPayment userPayment);
	void delete(UserPayment userPayment);
	UserPayment find(String userPaymentCode);
	/*
	 *
	 private User user;
	private String cardHolderName;
	private String cardType;
	private Date expiryDate;
	private String securityCode;
	private String paymentType;
	private Long balance;
	 */
	UserPayment validate(String cardHolderName,String cardType,String securityCode,String paymentType);

}
