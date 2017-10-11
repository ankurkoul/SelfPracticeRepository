package com.foodkhana.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;// pk
	private String pName;
	private double price;
	private String description;
	private String vegOrNon;
	@OneToOne
	private Vendor vendor;
	private String feedback;
	// bi-directional many-to-one association to Category
	@OneToOne
	private Category category;
	/*@OneToMany
	private Set<ProductImages> productImages=new LinkedHashSet<>();*/
	


	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getVegOrNon() {
		return vegOrNon;
	}

	public void setVegOrNon(String vegOrNon) {
		this.vegOrNon = vegOrNon;
	}

	/*public Set<ProductImages> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ProductImages> productImages) {
		this.productImages = productImages;
	}*/

	@Override
	public String toString() {
		return "Product [id=" + id + ", pName=" + pName + ", price=" + price
				+ ", description=" + description + "]";
	}

}
