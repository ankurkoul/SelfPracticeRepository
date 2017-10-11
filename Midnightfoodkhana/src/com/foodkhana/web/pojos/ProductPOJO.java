package com.foodkhana.web.pojos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.foodkhana.domain.Category;
import com.foodkhana.domain.Vendor;
@Component
public class ProductPOJO {

	private  Long id;//pk
	private String pName;
	private double price;
	private String description;
//	private List<ProductImagesPOJO> productImages;
	private String vegOrNon;
	private String categoryName;
	private VendorPOJO vendor;
	private String feedback;
	
	public String getVegOrNon() {
		return vegOrNon;
	}
	public void setVegOrNon(String vegOrNon) {
		this.vegOrNon = vegOrNon;
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
	/*public List<ProductImagesPOJO> getProductImages() {
		return productImages;
	}
	public void setProductImages(List<ProductImagesPOJO> productImages) {
		this.productImages = productImages;
	}*/
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public VendorPOJO getVendor() {
		return vendor;
	}
	public void setVendor(VendorPOJO vendor) {
		this.vendor = vendor;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	

	
	
	
}
