package com.foodkhana.web.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;


@Component
public class UserOrderPOJO {
	private Long id;
	private Date orderOn;
	private String email;
	private UserPaymentPOJO userPayment;
	List<ProductPOJO> productList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getOrderOn() {
		return orderOn;
	}
	public void setOrderOn(Date orderOn) {
		this.orderOn = orderOn;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserPaymentPOJO getUserPayment() {
		return userPayment;
	}
	public void setUserPayment(UserPaymentPOJO userPayment) {
		this.userPayment = userPayment;
	}
	public List<ProductPOJO> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductPOJO> productList) {
		this.productList = productList;
	}

	
	
	
	
}
