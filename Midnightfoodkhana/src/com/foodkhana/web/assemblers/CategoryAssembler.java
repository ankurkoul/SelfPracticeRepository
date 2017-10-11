package com.foodkhana.web.assemblers;

import org.springframework.stereotype.Component;

import com.foodkhana.domain.Category;
import com.foodkhana.web.pojos.CategoryPOJO;

@Component
public class CategoryAssembler {

	public CategoryPOJO fromEntityToPojo(Category catgeory) {
		CategoryPOJO pojo = new CategoryPOJO();
		pojo.setId(catgeory.getId());
		pojo.setCategoryName(catgeory.getCategoryName());
		pojo.setDescription(catgeory.getDescription());
		return pojo;
	}
}