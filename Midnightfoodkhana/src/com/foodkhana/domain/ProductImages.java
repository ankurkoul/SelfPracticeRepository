package com.foodkhana.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ProductImages implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  Long id;//pk
	//private String pName;
	@Column(name="IMAGE_PATH")
	private String pImage;
//	private Product product;

	
	/*public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
*/	public Long getId() {
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
/*	@Override
	public String toString() {
		return "ProductImages [id=" + id + ", pImage=" + pImage + ", product=" + product + "]";
	}
	*/
	
	
	
}
