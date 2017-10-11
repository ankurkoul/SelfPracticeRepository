package com.foodkhana.web.pojos;

import org.springframework.stereotype.Component;

@Component
public class SalesCartPOJO {
	// item no,product
	// name,image,qty,price,total
	// to update and delete
	// private FoodItemsPOJO foodItemsPOJO;
	private long pid;
	private String pName;
	private String pImage;
	private String pDescription;
	 private double price;
	private long qty;
	private long totalPrice;
	
	
	
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getQty() {
		return qty;
	}
	public void setQty(long qty) {
		this.qty = qty;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}



}
