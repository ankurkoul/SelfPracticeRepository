package com.foodkhana.web.pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
public class VendorPOJO implements Serializable {

	private Long id;// pk
	private String vendorName;
	private AddressPOJO addPojo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String venorName) {
		this.vendorName = venorName;
	}

	public AddressPOJO getAddPojo() {
		return addPojo;
	}

	public void setAddPojo(AddressPOJO addPojo) {
		this.addPojo = addPojo;
	}

}
