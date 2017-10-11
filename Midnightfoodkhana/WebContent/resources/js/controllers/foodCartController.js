var app = angular.module('foodKhana.controllers');
app.controller('FoodCartController', [
		'$scope',
		'CategoryService',
		'GlobalDataService',
		'localStorageService',
		function($scope, CategoryService, GlobalDataService,
				localStorageService) {
			$scope.onlyNumbers = /^\d+$/;
			$scope.updateSingleProduct = function() {
				updateTotalPrice($scope.cart);
			};

			$scope.removeCarteProduct = function(pid) {
				for ( var pos in $scope.cart) {
					if ($scope.cart[pos].productId !== undefined
							&& $scope.cart[pos].productId === pid) {
						$scope.cart.splice(pos,1);
					}
				}
				$scope.updateSingleProduct();
				GlobalDataService.setCart($scope.cart);
				localStorageService.set('cart', $scope.cart);
			};

			/*if ($scope.cart.length == 0) {
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
						$scope.cart[i] = qty;
						$scope.productQty = '';
						flag = false;
					}
				}
				if (flag) {
					setCart(pid, desc, price, qty);
				}

			}
			$scope.productprice=productPriceFunction($scope.cart.price,$scope.cart.qty);
			updateTotalPrice($scope.cart);*/

			var updateTotalPrice = function(cart) {
				console.log("length-->" + cart.length);
				var totalPrice = 0;
				for ( var i in cart) {
					if (cart[i].price !== undefined
							&& cart[i].qty !== undefined) {
					console.log("p" + cart[i].price);
					console.log("q" + cart[i].qty);
						totalPrice += cart[i].price * cart[i].qty;
					}
				}

				$scope.cart.totalPrice = totalPrice;

			};
			/*	var setCart = function(pid, desc, price, qty) {

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

				};*/
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
								//alert("found1");
								$scope.cart[i].qty = qty;
								$scope.productQty = '';
								flag = false;
							}
						}
						if (flag) {
							setCart(pid, desc, price, qty);
						}

					}
					$scope.productprice = productPriceFunction(
							$scope.cart.price, $scope.cart.qty);
					updateTotalPrice($scope.cart);
				}
			};

			$scope.onLoad = function() {
				$scope.cart = localStorageService.get('cart');
				updateTotalPrice($scope.cart);

			};

			//	
			$scope.$watch(function() {
				return GlobalDataService.getCart();
			}, function(newValue, oldValue) {
				if (newValue !== oldValue)
					$scope.cart = newValue;

			});

		} ]);