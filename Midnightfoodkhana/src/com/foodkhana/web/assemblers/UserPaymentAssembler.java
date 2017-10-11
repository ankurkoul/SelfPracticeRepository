package com.foodkhana.web.assemblers;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Component
public class UserPaymentAssembler {
	private Long id;
	private String email;
	private String cardHolderName;
	private String cardType;
	
	private String securityCode;
	private String paymentType;
	
	
	
	
		
}
