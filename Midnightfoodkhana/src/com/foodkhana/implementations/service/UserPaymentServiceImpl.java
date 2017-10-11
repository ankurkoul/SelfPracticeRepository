package com.foodkhana.implementations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodkhana.domain.UserPayment;
import com.foodkhana.repos.IUserPaymentRepo;
import com.foodkhana.service.IUserPaymentService;

@Service
public class UserPaymentServiceImpl implements IUserPaymentService {

	@Autowired
	IUserPaymentRepo IUserPaymentRepo;

	public void setIUserPaymentRepo(IUserPaymentRepo IUserPaymentRepo) {
		this.IUserPaymentRepo = IUserPaymentRepo;
	}

	public void save(UserPayment UserPayment){
		IUserPaymentRepo.save(UserPayment);
	}

	public void update(UserPayment UserPayment){
		IUserPaymentRepo.update(UserPayment);
	}

	public void delete(UserPayment UserPayment){
		IUserPaymentRepo.delete(UserPayment);
	}

	public UserPayment find(String UserPaymentCode){
		return IUserPaymentRepo.find(UserPaymentCode);
	}

	@Override
	public UserPayment validate(String cardHolderName, String cardType,
			String securityCode, String paymentType) {
		
		return IUserPaymentRepo.validate(cardHolderName, cardType, securityCode, paymentType);
	}

}
