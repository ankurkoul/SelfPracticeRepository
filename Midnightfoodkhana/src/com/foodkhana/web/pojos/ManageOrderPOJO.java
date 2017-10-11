package com.foodkhana.web.pojos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
public class ManageOrderPOJO {
	private List<CarrierProductPOJO> productList;
	private String userName ;
	private String password;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CarrierProductPOJO> getProductList() {
		return productList;
	}

	public void setProductList(List<CarrierProductPOJO> productList) {
		this.productList = productList;
	}

}
