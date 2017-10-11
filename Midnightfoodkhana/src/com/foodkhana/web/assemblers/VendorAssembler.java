package com.foodkhana.web.assemblers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foodkhana.domain.Address;
import com.foodkhana.domain.Vendor;
import com.foodkhana.web.pojos.VendorPOJO;
@Component
public class VendorAssembler {

	@Autowired
private AddressAssembler addressAssembler;	
	public VendorPOJO fromEntityToPojo(Vendor entity){
		VendorPOJO pojo=new VendorPOJO();
		pojo.setId(entity.getId());
		pojo.setVendorName(entity.getVendorName());
		Address add=entity.getAddress();
		pojo.setAddPojo(addressAssembler.fromEntityToPojo(add));
/*		List<ProductImagesPOJO>imagesPOJOList=new ArrayList<ProductImagesPOJO>();
		 for(ProductImages pi:product.getProductImages()){
			 imagesPOJOList.add( productImagesAssembler.fromEntityToPojo(pi));
		 }
		productRep.setProductImages(imagesPOJOList);
*/		return pojo;
	}

	
	
	
}
