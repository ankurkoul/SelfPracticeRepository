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
		'localStorageService','$location',
		function($scope, CategoryService, GlobalDataService,
				localStorageService,$location) {
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
					console.log(payload.data.length);
					$scope.categories = payload.data;
					$scope.cart=localStorageService.get('cart');
					if($scope.cart===null	|| $scope.cart ===undefined ){
						$scope.cart = [];
					}
					
				}, function(errorPayload) {
					console.log(errorPayload);
					$scope.catError = errorPayload.message;
					$scope.dataLoading = false;

				});
			};
			$scope.catName;
			$scope.setCatname = function(value) {
				$scope.catName;
			};
			
		
			/*$('#productModal').on('show.bs.modal', function (e) {
			    window.history.pushState('forward', null, '#modal');
			});*/

			/*$('#productModal').on('hide.bs.modal', function (e) {
			    //pop the forward state to go back to original state before pushing the "Modal!" button
				  if(location.hash=='#modal')window.history.back();
			});
			*/
			$(window).on('popstate', function (event) {  //pressed back button
			    if(event.state!==null)$('#productModal').modal('hide');
			});
		 
			$scope.cart = [];
			
			$scope.cartTotalPrice = 0;
			$scope.onlyNumbers = /^\d+$/;
			$scope.cart.count = 0;
			$scope.productQty = '';

			$scope.cart.totalPrice = 0;
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
			
			$scope.closeModal=function(){
				$('#productModal').modal('hide');
				$location.path('/foodCart');				
			}
			$scope.addCart = function(pid, desc, price, qty) {
				if (qty == undefined || qty < 1) {
					$scope.productQty = '';
					console.log("fill qty before adding to cart");
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
								console.log("found1");
								$scope.cart[i].qty = qty;
								$scope.productQty = '';
								flag = false;
								GlobalDataService.setCart($scope.cart);
								localStorageService.set('cart', $scope.cart);
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
							console.log(JSON.stringify(payload.data));
							$scope.product = payload.data;
							$scope.catName = catName;
							// $location.path('/products');

						}, function(errorPayload) {
							$scope.error = errorPayload.message;
						});
			};
		} ]);