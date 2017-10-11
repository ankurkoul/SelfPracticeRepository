package com.foodkhana.web.assemblers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foodkhana.domain.Category;
import com.foodkhana.domain.Product;
import com.foodkhana.web.pojos.ProductPOJO;
@Component
public class ProductAssembler {

	/*@Autowired(required=true)
	private ProductImagesAssembler productImagesAssembler;*/
	@Autowired
	private VendorAssembler vendorAssembler;
	public ProductPOJO fromEntityToPojo(Product product){
		ProductPOJO productRep=new ProductPOJO();
		productRep.setId(product.getId());
		productRep.setDescription(product.getDescription());
		productRep.setpName(product.getpName());
		productRep.setPrice(product.getPrice());
		productRep.setVegOrNon(product.getVegOrNon());
		Category cat=product.getCategory();
		if(cat!=null)
		productRep.setCategoryName(cat.getCategoryName());
		
		productRep.setVendor(vendorAssembler.fromEntityToPojo(product.getVendor()));
		productRep.setFeedback(product.getFeedback());
/*		List<ProductImagesPOJO>imagesPOJOList=new ArrayList<ProductImagesPOJO>();
		 for(ProductImages pi:product.getProductImages()){
			 imagesPOJOList.add( productImagesAssembler.fromEntityToPojo(pi));
		 }
		productRep.setProductImages(imagesPOJOList);
*/		return productRep;
	}
	
	
	/*public  Product fromPojoToEntity( ProductPOJO pojo){
		Product entity=new Product();
		entity.setId(pojo.getId());
		entity.setDescription(pojo.getDescription());
		entity.setpName(pojo.getpName());
		entity.setPrice(pojo.getPrice());
		entity.setVegOrNon(pojo.getVegOrNon());
		Category cat=pojo.getCategory();
		if(cat!=null)
		entity.setCategoryName(cat.getCategoryName());
		
		entity.setVendor(vendorAssembler.fromEntityToPojo(pojo.getVendor()));
		entity.setFeedback(pojo.getFeedback());
		List<ProductImagesPOJO>imagesPOJOList=new ArrayList<ProductImagesPOJO>();
		 for(ProductImages pi:product.getProductImages()){
			 imagesPOJOList.add( productImagesAssembler.fromEntityToPojo(pi));
		 }
		productRep.setProductImages(imagesPOJOList);
		return entity;
	}*/
	

	
	
	
}
