package com.foodkhana.web.resource;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodkhana.domain.AdminUser;
import com.foodkhana.domain.User;
import com.foodkhana.service.IAdminUserService;
import com.foodkhana.service.IUserService;
import com.foodkhana.web.assemblers.AdminUserAssembler;
import com.foodkhana.web.assemblers.UserAssembler;
import com.foodkhana.web.pojos.UserPOJO;

@RestController
@RequestMapping("/user")
public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	IUserService userService;
	@Autowired
	UserAssembler userAssembler;
	@Autowired
	IAdminUserService adminUserService;
	@Autowired
	AdminUserAssembler adminUserAssembler;

	/*
	 * form for sign up and signin my account feature--->sign up/sign out/orders
	 * history====>user controller
	 */
/*
	@RequestMapping(value = "/customerList", method = RequestMethod.GET)
	public String displayCustomers(Model m) {
		logger.info("This is an info log entry");
		logger.error("This is an error log entry");

		return "partials/customers";
	}

	@RequestMapping(value = "/customerDetails", method = RequestMethod.GET)
	public String displayCustomerDetails(Model m) {

		return "partials/detailsPage";
	}*/

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public void check() {
		logger.info("in check--------------------------->");
		logger.debug("in check--------------------------->");

	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<UserPOJO> authenticateUser(@RequestBody UserPOJO user) {

		logger.debug("in authenticate--------------------------->" + user);
		User entity = userService.getUser(user.getUserName(),
				user.getPassword());
		if (entity != null) {
			UserPOJO userPOJO = userAssembler.fromEntityToPojo(entity);
			logger.debug("----->" + userPOJO);
			return new ResponseEntity<UserPOJO>(userPOJO, HttpStatus.OK);

		} else {
			return new ResponseEntity("No Customer found for ID "
					+ user.getUserName(), HttpStatus.NOT_FOUND);
		}

	}
	
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public ResponseEntity<UserPOJO> adminUser(@RequestBody UserPOJO user) {

		AdminUser entity = adminUserService.getUser(user.getUserName(),
				user.getPassword());
		if (entity != null) {
			UserPOJO userPOJO = adminUserAssembler.fromEntityToPojo(entity);

			return new ResponseEntity<UserPOJO>(userPOJO, HttpStatus.OK);

		} else {
			return new ResponseEntity("No Admin found for ID "
					+ user.getUserName(), HttpStatus.NOT_FOUND);
		}

	}
	

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<UserPOJO> signUpUser(@RequestBody UserPOJO pojo) {

		if (pojo != null) {
			logger.debug("in signUp--------------------------->" + pojo);
			User user = userAssembler.fromPojoToEntity(pojo);
			userService.save(user);
			UserPOJO userPOJO = userAssembler.fromEntityToPojo(user);

			return new ResponseEntity<UserPOJO>(userPOJO, HttpStatus.OK);

		} else {
			return new ResponseEntity("No Customer found for ID ",
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<UserPOJO> updateUser(@RequestBody UserPOJO pojo) {

		if (pojo != null) {
			logger.debug("in signUp--------------------------->" + pojo);
			User user = userAssembler.fromPojoToEntity(pojo);
			userService.update(user);
			UserPOJO userPOJO = userAssembler.fromEntityToPojo(user);

			return new ResponseEntity<UserPOJO>(userPOJO, HttpStatus.OK);

		} else {
			return new ResponseEntity("No Customer found for ID ",
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/AllUsers", method = RequestMethod.GET)
	public ResponseEntity<List<UserPOJO>> findUsers() {
		List<UserPOJO> userPOJOList = new ArrayList<>();
		for (User user : userService.findUsers()) {
			userPOJOList.add(userAssembler.fromEntityToPojo(user));
		}
		return new ResponseEntity<List<UserPOJO>>(userPOJOList, HttpStatus.OK);

	}


	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteCustomer(@PathVariable("id")  Long id) {
		userService.delete(id);
		return new ResponseEntity(id, HttpStatus.OK);

	}

}
