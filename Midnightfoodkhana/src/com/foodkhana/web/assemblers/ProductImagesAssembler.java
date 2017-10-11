package com.foodkhana.web.assemblers;

import org.springframework.stereotype.Component;

import com.foodkhana.domain.ProductImages;
import com.foodkhana.web.pojos.ProductImagesPOJO;
@Component
public class ProductImagesAssembler {


	public ProductImagesPOJO fromEntityToPojo(ProductImages productImages){
		ProductImagesPOJO pImagesPOJO=new ProductImagesPOJO();
		pImagesPOJO.setId(productImages.getId());
		pImagesPOJO.setpImage(productImages.getpImage());
		return pImagesPOJO;
		 
	 }
	
	
}
