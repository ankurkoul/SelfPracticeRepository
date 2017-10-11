package com.foodkhana.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	//private long userId;
	//	private long orderId;
//	private long paymentId;
	private Date orderOn;
	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;
	/*@OneToOne
	private UserPayment userPayment;*/
	@OneToMany
	private List<Product> product=new ArrayList<Product>();
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/*public UserPayment getUserPayment() {
		return userPayment;
	}
	public void setUserPayment(UserPayment userPayment) {
		this.userPayment = userPayment;
	}*/
	
	
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	
	
	
}
