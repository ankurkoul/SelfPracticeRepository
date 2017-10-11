package com.foodkhana.web.pojos;

import org.springframework.stereotype.Component;
@Component
public class ProductImagesPOJO {

	private  Long id;//pk
	private String pImage;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	@Override
	public String toString() {
		return "ProductImagesPojo [id=" + id + ", pImage=" + pImage + "]";
	}

	
	
}
