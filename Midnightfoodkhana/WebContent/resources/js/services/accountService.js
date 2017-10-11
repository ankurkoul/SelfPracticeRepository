
var app = angular.module('foodkhana.services');
app.factory('AuthenticationService', [
		'$http',
		'$cookies',
		function($http, $cookies) {
			var service = {};
			service.Login = function(username, password) {
			//	alert("here Login--->" + username + "	:	" + password);
				return $http.post('/foodkhana/rest/user/authenticate',
						{
							userName : username,
							password : password
						});
			};

			service.Signup = function(jsonObject) {
		//		alert("here Signup--->" + JSON.stringify(jsonObject));
				return $http({
					url : "/foodkhana/rest/user/signup",
					dataType : 'json',
					method : 'POST',
					data : jsonObject,
					headers : {
						"Content-Type" : "application/json"
					}
				});
				// return $http.post({'/Midnightfoodkhana/rest/user/signup', {
				// cred });
			};
			service.AdminLogin = function(username, password) {
	//			alert("here Login--->" + username + "	:	" + password);
				return $http.post('/foodkhana/rest/user/adminLogin', {
					userName : username,
					password : password
				});
			};
			service.Remove = function(id) {
	//			alert("here Remove--->" + id);
				return $http({
					url : "/foodkhana/rest/user/deleteUser",
					method : 'DELETE',
					params : {
						id : "@id"
					},

				});
				// return $http.post({'/Midnightfoodkhana/rest/user/signup', {
				// cred });
			};

			service.FindAll = function(id) {
//				alert("here Remove--->" + id);
				return $http("/foodkhana/rest/user/AllUsers");
				// return $http.post({'/Midnightfoodkhana/rest/user/signup', {
				// cred });
			};

			return service;
		} ]);

app.factory('GlobalDataService', [ '$cookies', function($cookies) {

	var data = {
		userName : '',
		userObject : {}
	};

	return {
		getName : function() {
			return data.userName;
		},
		setName : function(userName) {
			data.userName = userName;
		},
		setUserObject : function(userObject) {

			data.userObject = userObject;

		},
		getUserObject : function() {

			return data.userObject;
		},
		clearData : function() {
			data = {};
			user = "";
			$cookies.remove("user");
			$cookies.remove("pass");
		},

		getCookieDataForUser : function() {
			user = $cookies.get('user');
			return user;
		},

		getCookieDataForPass : function(pass) {
			user = $cookies.get('pass');
			return user;
		},
		setCookieDataForUser : function(user) {

			$cookies.put('user', user);

		},

		setCookieDataForPass : function(pass) {

			$cookies.put('pass', pass);

		},

		getAdmin : function() {
			return data.admin;
		},
		setAdmin : function(userName) {
			data.admin = userName;
		},
		setCart : function(cart) {
			data.cart = cart;
		},
		getCart : function() {
			return data.cart;
		},removeCart	:function(){
			data.cart=[];
		}

	};
} ]);

app.factory('CategoryService', [ '$http', function($http) {
	var service = {};
	service.getAllCategories = function() {

		return $http.get('/foodkhana/rest/Menu/allCategories');
	};

	service.getProductOfCategory = function(id) {
		console.log("here selectItemOfCategory--->" + JSON.stringify(id));
		return $http({
			method : "GET",
			url : "/foodkhana/rest/Menu/category",
			params : {
				id : id
			}
		})
	};
	service.AdminLogin = function(username, password) {
		alert("here Login--->" + username + "	:	" + password);
		return $http.post('/foodkhana/rest/user/adminLogin', {
			userName : username,
			password : password
		});
	};
	service.Remove = function(id) {
		alert("here Remove--->" + id);
		return $http({
			url : "/foodkhana/rest/user/deleteUser",
			method : 'DELETE',
			params : {
				id : id
			},
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	
	};

	service.FindAll = function(id) {
		alert("here Remove--->" + id);
		return $http("/foodkhana/rest/user/AllUsers");
		
	};

	return service;
} ]);

app.factory('OrderService', [ '$http', function($http) {
	var service = {};
	service.getAllOrders = function() {

		return $http.get('/foodkhana/rest/Order/allOrders');
	};

	service.saveOrder = function(productList,userName,password) {
		alert("p---->"+JSON.stringify(productList));
		alert("u---->"+JSON.stringify(userName));
		alert("x---->"+JSON.stringify(password));
		return $http.post("/foodkhana/rest/Order/saveOrder", {
			productList : productList,
			userName	: userName,
			password	:password
		});
	};

	service.getOrderForUser = function(username, password) {
		console.log("here selectItemOfCategory--->" + JSON.stringify(username));
		return $http.post("/foodkhana/rest/Order/userOrder", {
			userName : username,
			password : password
		});

	};

	service.getOrderInfoForUser = function(id) {

		console.log("here selectItemOfCategory--->" + JSON.stringify(id));
		return $http({
			method : "GET",
			url : "/foodkhana/rest/Order/orderInfo",
			params : {
				id : id
			}
		});
	};

	return service;
} ]);
