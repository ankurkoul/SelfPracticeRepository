package com.foodkhana.web.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodkhana.domain.Category;
import com.foodkhana.domain.Product;
import com.foodkhana.domain.UserPayment;
import com.foodkhana.service.ICategoryService;
import com.foodkhana.service.IProductService;
import com.foodkhana.service.IUserPaymentService;
import com.foodkhana.utilities.NullGuard;
import com.foodkhana.web.assemblers.CategoryAssembler;
import com.foodkhana.web.assemblers.ProductAssembler;
import com.foodkhana.web.pojos.CategoryPOJO;
import com.foodkhana.web.pojos.ProductPOJO;
import com.foodkhana.web.pojos.UserOrderPOJO;
import com.foodkhana.web.pojos.UserPaymentPOJO;

@RestController
public class WebOrderingController {
	 private Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	IProductService iProductService;

	@Autowired
	IUserPaymentService iUserPaymentService;
	@Autowired
	ProductAssembler productAssembler;

	//@Autowired
	//Map<String, Set<ProductPOJO>> cart;
	@Autowired
	ICategoryService iCategoryService;
	@Autowired
	CategoryAssembler categoryAssembler;

	
	// home menu options -------->
	 
	// allow user to see all food items offered with nice images
	// select an item to place an order

	@RequestMapping(value = "/AllfoodItems", method = RequestMethod.GET)
	public List<ProductPOJO> getAllFooditems() {

		//FoodItemsPOJO foodItemsRep = new FoodItemsPOJO();
		List<ProductPOJO> pList = new ArrayList<ProductPOJO>();
		// ProductPOJO productRep;
		for (Product p : iProductService.findAll()) {
			pList.add(productAssembler.fromEntityToPojo(p));
		}
		//foodItemsRep.setProductList(pList);
	//	return foodItemsRep;
		return pList;

	}
	
	
	// * menu -------->
	 
	// menu option to show category wise menu
	// and allow to add item to cart
	
	//sandwich//soap
	@RequestMapping(value = "/AllCategories", method = RequestMethod.GET)
	public List<CategoryPOJO> getAllCategories() {

		List<CategoryPOJO> categoryPOJOs=new ArrayList<>();
		for (Category catgeory : NullGuard.forList(iCategoryService.getAllCategories())) {
			CategoryPOJO pojo=categoryAssembler.fromEntityToPojo(catgeory);
			categoryPOJOs.add(pojo);
		};
		
		return categoryPOJOs;

	}
	
	//veg varieties
	//non veg varieties
	@RequestMapping(value = "/CategoryItems/{id}", method = RequestMethod.GET)
	public List<ProductPOJO> getSelectedCategoryItems(@PathVariable("id") Long id) {

		List<ProductPOJO> pList = new ArrayList<ProductPOJO>();
		// ProductPOJO productRep;
		for (Product p : iProductService.findByCategory(id)) {
			pList.add(productAssembler.fromEntityToPojo(p));
		}
		
		return pList;

	}
	
	
	//addtoCart----->Ajs
	

	/*@RequestMapping(value = "/FoodItems/{cart}", method = RequestMethod.GET)
	public FoodItemsPOJO selectedFoodItem(@RequestBody SalesCartPOJO cart ) {
	
		
		
		 
		 	private Long id;//pk
	//private long orderId;//order id to linkto user orders
	//private long payementId;
	private long itemNo;
	private Date soldOn;
	private UserOrder order;
	private int qty;
		 
		 
		
//selected fooditems
		UserOrderPOJO orderPOJO=new UserOrderPOJO();
		Sales sales=new Sales();
	for(	ProductPOJO productPOJO:NullGuard.forList(itemsPOJO.getProductList())){
		UserOrder order=new UserOrder();
		order.setOrderOn(new Date());
		order.setUser(user);
		order.setUserPayment(userPayment);
		
		sales.setOrder(order);
		sales.setItemNo(productPOJO.g);
		
	}
		FoodItemsPOJO foodItemsRep = new FoodItemsPOJO();
		List<ProductPOJO> pList = new ArrayList<ProductPOJO>();
		// ProductPOJO productRep;
		for (Product p : iProductService.findAll()) {
			pList.add(productAssembler.fromEntityToPojo(p));
		}
		foodItemsRep.setProductList(pList);
		return foodItemsRep;

	}

	*/

	

	
	// * cart -------->
	 
	// to see cart items placed by him--->item no,product
	// name,image,qty,price,total
	// to update and delete
	// if clicked confirm ask for login/sign up===>if not done
	// then payment option

	@RequestMapping(value = "/payment/{payment}", method = RequestMethod.GET)
	public UserOrderPOJO checkPayment(@RequestBody UserPaymentPOJO payment) {
		UserPayment up = iUserPaymentService.validate(
				payment.getCardHolderName(), payment.getCardType(),
				payment.getSecurityCode(), payment.getPaymentType());
		if (up.getExpiryDate().compareTo(new Date()) > 0) {
			return new UserOrderPOJO();
		} else {

			return null;
		}

	}

/*	@RequestMapping(value = "/Cart/email/{cart}", method = RequestMethod.GET)
	public void selectedCart(@RequestBody SalesCartPOJO cart) {
		UserOrder userOrder = new UserOrder();
		userOrder.setOrderOn(new Date());
		userOrder.setUser(user);
		userOrder.setUserPayment(userPayment);

		Sales sales = new Sales();
		sales.setItemNo(itemNo);
		sales.setOrders(userOrder);

		
		 * FoodItemsPOJO foodItemsRep = new FoodItemsPOJO(); List<ProductPOJO>
		 * pList = new ArrayList<ProductPOJO>(); // ProductPOJO productRep; for
		 * (Product p : iProductService.findByCategory(id)) {
		 * pList.add(productAssembler.fromEntityToPojo(p)); }
		 * foodItemsRep.setProductList(pList); return foodItemsRep;
		 

	}

	
	 * finally order confirmation screen -------->
	 
	// success/failure--->modal fail

	
	 * my account feature --------> sign up/sign out/orders history====>user
	 * controller
	 */
}
