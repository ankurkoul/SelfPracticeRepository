var app = angular.module('foodKhana.controllers');
app.filter('capitalize', function() {
	return function(input) {
		return (!!input) ? input.charAt(0).toUpperCase()
				+ input.substr(1).toLowerCase() : '';
	}
});
app.controller('MenuController', [
		'$scope',
		'CategoryService',
		'GlobalDataService',
		'localStorageService',
		function($scope, CategoryService, GlobalDataService,
				localStorageService) {
			$scope.categories = [];
			$(document).ready(function() {
				$("[rel='tooltip']").tooltip();

				$('.thumbnail').hover(function() {
					$(this).find('.caption').slideDown(250); // .fadeIn(250)
				}, function() {
					$(this).find('.caption').slideUp(250); // .fadeOut(205)
				});
			});
			$scope.loadCategories = function() {
				var promise = CategoryService.getAllCategories();
				promise.then(function(payload) {
					alert(payload.data.length);
					$scope.categories = payload.data;
					$scope.cart=localStorageService.get('cart');
					
				}, function(errorPayload) {
					alert(errorPayload);
					$scope.catError = errorPayload.message;
					$scope.dataLoading = false;

				});
			};
			$scope.catName;
			$scope.setCatname = function(value) {
				$scope.catName;
			};
			
		 

			$scope.cart = [];
			$scope.cartTotalPrice = 0;

			$scope.cart.count = 0;
			$scope.productQty = '';

			$scope.cart.totalPrice = 0;
			var updateTotalPrice = function(cart) {
				alert("length-->" + cart.length);
				var totalPrice = 0;
				for ( var i in cart) {
					if (cart[i].price !== undefined
							&& cart[i].qty !== undefined) {
						alert("p" + cart[i].price);
						alert("q" + cart[i].qty);
						totalPrice += cart[i].price * cart[i].qty;
					}
				}

				$scope.cart.totalPrice = totalPrice;
			};
			var setCart = function(pid, desc, price, qty) {

				cartObject = {};
				cartObject.productId = pid;
				cartObject.name = desc;
				cartObject.price = price;
				cartObject.qty = qty;
				$scope.cart.push(cartObject);
				$scope.cart.count++;
				GlobalDataService.setCart($scope.cart);
				localStorageService.set('cart', $scope.cart);
				$scope.productQty = '';

			};
			$scope.addCart = function(pid, desc, price, qty) {
				if (qty == undefined || qty < 1) {
					$scope.productQty = '';
					alert("fill qty before adding to cart");
				} else {
					if ($scope.cart.length == 0) {
						setCart(pid, desc, price, qty);
						// updateTotalPrice($scope.cart);
						$scope.cart.count++;
						GlobalDataService.setCart($scope.cart);
						localStorageService.set('cart', $scope.cart);
						$scope.productQty = '';
					} else {
						var flag = true;
						for ( var i in $scope.cart) {
							if ($scope.cart[i].productId !== undefined
									&& $scope.cart[i].productId === pid) {
								alert("found1");
								$scope.cart[i].qty = qty;
								$scope.productQty = '';
								flag = false;
							}
						}
						if (flag) {
							setCart(pid, desc, price, qty);
						}

					}
					updateTotalPrice($scope.cart);
				}
			};

			$scope.selectedCart = function(cat, catName) {
				CategoryService.getProductOfCategory(cat).then(
						function(payload) {
							alert(JSON.stringify(payload.data));
							$scope.product = payload.data;
							$scope.catName = catName;
							// $location.path('/products');

						}, function(errorPayload) {
							$scope.error = errorPayload.message;
						});
			};
		} ]);