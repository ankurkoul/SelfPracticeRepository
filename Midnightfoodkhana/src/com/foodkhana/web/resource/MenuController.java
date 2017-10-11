package com.foodkhana.web.resource;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodkhana.domain.Category;
import com.foodkhana.domain.Product;
import com.foodkhana.service.ICategoryService;
import com.foodkhana.web.assemblers.CategoryAssembler;
import com.foodkhana.web.assemblers.ProductAssembler;
import com.foodkhana.web.pojos.CategoryPOJO;
import com.foodkhana.web.pojos.ProductPOJO;

@RestController
@RequestMapping("/Menu")
public class MenuController {

	//addcategory
	//addproduct
	//modifyproduct
	
	Logger log=Logger.getLogger(MenuController.class);

	@Autowired
	ICategoryService catService;
	@Autowired
	CategoryAssembler catAssembler;
	@Autowired
	ProductAssembler productAssembler;
	

	@RequestMapping(value = "/allCategories", method = RequestMethod.GET)
	public ResponseEntity<List<CategoryPOJO>> findAllCategories() {
		List<CategoryPOJO>catPOJOList = new ArrayList<>();
		for (Category cat : catService.getAllCategories()) {
			catPOJOList.add(catAssembler.fromEntityToPojo(cat));
		}
		return new ResponseEntity<List<CategoryPOJO>>(catPOJOList, HttpStatus.OK);

	}


	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ResponseEntity getProductOfCategory(   @RequestParam(value="id") Long id) {
		log.info("in parthms----=====>");
		List<Product> productList=catService.getCategoryProduct(id);
		List<ProductPOJO> productPOJOList = new ArrayList<>();
		for (Product prod : productList) {
			productPOJOList.add(productAssembler.fromEntityToPojo(prod));
		}
		return new ResponseEntity(productPOJOList, HttpStatus.OK);
		
	}
/*	@RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
	public ResponseEntity getProductOfCategorywasasas(@RequestParam("id")  Long id) {
		log.info("in parms----=====>");
		List<Product> productList=catService.getCategoryProduct(id);
		List<ProductPOJO> productPOJOList = new ArrayList<>();
		for (Product prod : productList) {
			productPOJOList.add(productAssembler.fromEntityToPojo(prod));
		}
		return new ResponseEntity(productPOJOList, HttpStatus.OK);

	}*/
	
	/*@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ResponseEntity getProductOfCategoryPath(@RequestParam(value = "id") Long pid) {
	log.info("in path=====>");
		List<Product> productList=catService.getCategoryProduct(pid);
		List<ProductPOJO> productPOJOList = new ArrayList<>();
		for (Product prod : productList) {
			productPOJOList.add(productAssembler.fromEntityToPojo(prod));
		}
		return new ResponseEntity(productPOJOList, HttpStatus.OK);

	}
*/
}
