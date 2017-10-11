package com.foodkhana.web.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodkhana.domain.Product;
import com.foodkhana.domain.User;
import com.foodkhana.domain.UserOrder;
import com.foodkhana.service.IProductService;
import com.foodkhana.service.IUserOrderService;
import com.foodkhana.service.IUserService;
import com.foodkhana.web.assemblers.ProductAssembler;
import com.foodkhana.web.assemblers.UserOrderAssembler;
import com.foodkhana.web.pojos.CarrierProductPOJO;
import com.foodkhana.web.pojos.ManageOrderPOJO;
import com.foodkhana.web.pojos.ProductPOJO;
import com.foodkhana.web.pojos.UserOrderPOJO;
import com.foodkhana.web.pojos.UserPOJO;

@RestController
@RequestMapping(value = "/Order")
public class OrderRetrievalController {
	// myaccount--->to see order by customer
	// my account---->all user orders by admin/employee

	// details of order--->for customer

	@Autowired
	IUserOrderService orderService;
	@Autowired
	UserOrderAssembler orderAssembler;
	@Autowired
	ProductAssembler productAssembler;
	@Autowired
	IProductService productService;
	
	@Autowired
	IUserService userService;

	@RequestMapping(value = "/userOrder", method = RequestMethod.POST)
	public ResponseEntity<List<UserOrderPOJO>> getOrder(
			@RequestBody UserPOJO user) {

		List<UserOrder> orderList = orderService.findForUser(
				user.getUserName(), user.getPassword());
		List<UserOrderPOJO> pojoList = new ArrayList<>();
		if (!orderList.isEmpty()) {
			for (UserOrder order : orderList) {
				UserOrderPOJO pojo = orderAssembler.fromEntityToPojo(order);
				pojoList.add(pojo);
			}
			return new ResponseEntity<List<UserOrderPOJO>>(pojoList,
					HttpStatus.OK);
		} else {
			return new ResponseEntity("No order found for ID "
					+ user.getUserName(), HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/allOrders", method = RequestMethod.GET)
	public ResponseEntity<List<UserOrderPOJO>> getOrder() {

		List<UserOrder> orderList = orderService.find();
		List<UserOrderPOJO> pojoList = new ArrayList<>();
		if (!orderList.isEmpty()) {
			for (UserOrder order : orderList) {
				UserOrderPOJO pojo = orderAssembler.fromEntityToPojo(order);
				pojoList.add(pojo);
			}
			return new ResponseEntity<List<UserOrderPOJO>>(pojoList,
					HttpStatus.OK);
		} else {
			return new ResponseEntity("No order found for ID ",
					HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/orderInfo", method = RequestMethod.GET)
	public ResponseEntity getOrderInfo(@RequestParam(value = "id") Long id) {

		List<Product> productList = orderService.getOrderProduct(id);
		List<ProductPOJO> productPOJOList = new ArrayList<>();
		for (Product prod : productList) {
			productPOJOList.add(productAssembler.fromEntityToPojo(prod));
		}
		return new ResponseEntity(productPOJOList, HttpStatus.OK);

	}

	/*
	 * productId : productId, paymentId:paymentId
	 */
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
	public ResponseEntity saveOrderInfo(@RequestBody ManageOrderPOJO productList) {
		UserOrder order = new UserOrder();
		List<Product> prodList = new ArrayList<>();
		Product pro=new Product();
		for (CarrierProductPOJO pojo : productList.getProductList()) {
			 pro.setId(pojo.getProductId());
			 pro = productService.find(pro.getId());	
			prodList.add(pro);
			
		}
		order.setOrderOn(new Date());
		User user=userService.getUser(productList.getUserName(), productList.getPassword());
		order.setUser(user);
		order.setProduct(prodList);
		orderService.save(order);

		return new ResponseEntity( HttpStatus.OK);
		
	}
}
