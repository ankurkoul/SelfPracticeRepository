package com.foodkhana.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Sales implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;// pk
	// private long orderId;//order id to linkto user orders
	// private long payementId;
	// private long itemNo;
	private Date soldOn;
	private int qty;
	private int totalPrice;
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "user_id")
	private UserOrder order;
	@OneToMany
	@JoinTable(name = "SALE_PRODUCT", joinColumns = @JoinColumn(name = "SALE_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private Set<Product> productList=new LinkedHashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * public long getItemNo() { return itemNo; } public void setItemNo(long
	 * itemNo) { this.itemNo = itemNo; }
	 */
	public Date getSoldOn() {
		return soldOn;
	}

	public void setSoldOn(Date soldOn) {
		this.soldOn = soldOn;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public UserOrder getOrder() {
		return order;
	}

	public void setOrder(UserOrder order) {
		this.order = order;
	}

	public Set<Product> getProductList() {
		return productList;
	}

	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	

}
