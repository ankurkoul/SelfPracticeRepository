package com.foodkhana.web.assemblers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foodkhana.domain.Product;
import com.foodkhana.domain.User;
import com.foodkhana.domain.UserOrder;
import com.foodkhana.web.pojos.ProductPOJO;
import com.foodkhana.web.pojos.UserOrderPOJO;

@Component
public class UserOrderAssembler {
	/*
	 * private Long id; private Date orderOn; private UserPOJO user; private
	 * UserPaymentPOJO userPayment;
	 */
	@Autowired
	ProductAssembler productAssembler;

	public UserOrderPOJO fromEntityToPojo(UserOrder order) {
		UserOrderPOJO pojo = new UserOrderPOJO();
		pojo.setId(order.getId());
		pojo.setOrderOn(order.getOrderOn());
		User user = order.getUser();
		if (user != null)
			pojo.setEmail(user.getEmail());
		List<ProductPOJO> productList = new ArrayList<ProductPOJO>();
		ProductPOJO productPojo;
		for (Product p : order.getProduct()) {
			productPojo = productAssembler.fromEntityToPojo(p);
			productList.add(productPojo);
		}

		pojo.setProductList(productList);
		return pojo;

	}

}
