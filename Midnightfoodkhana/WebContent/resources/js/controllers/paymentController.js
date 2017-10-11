var app = angular.module('foodKhana.controllers');
app.controller('PaymentController', [
		'$scope',
		'CategoryService',
		'GlobalDataService',
		'OrderService',
		'localStorageService',
		function($scope, CategoryService, GlobalDataService,OrderService,
				localStorageService) {
			$scope.onlyNumbers = /^\d+$/;
			$scope.cart=localStorageService.get("cart");
			$scope.updateSingleProduct = function() {
				updateTotalPrice($scope.cart);
			};

			$scope.filterValue = function($event){
		        if(isNaN(String.fromCharCode($event.keyCode))){
		            $event.preventDefault();
		        }
		};
		
		flag = true
		
		$scope.productflag=false;
	$scope.payment={};
		
		$scope.productInfo=function(){
			console.log(JSON.stringify($scope.cart))
			OrderService.getOrderInfoForUser($scope.cart).then(
					function(payload) {
						
						$scope.products = payload.data;
						// $location.path('/products');
						$scope.productflag=true;

					}, function(errorPayload) {
						$scope.error = errorPayload.message;
					});
		};
		
		
		$scope.submitform=function () {
			  var f = document.getElementsByTagName('form')[0];
			  if(f.checkValidity()) {
					$scope.saveOrder();
			  } else {
			    alert(document.getElementById('example').validationMessage);
			  }
			}
		function loginFunction(){
			$location.path('/myAccount'); 
		}
		$scope.saveOrder=function( ){
			console.log("u-->" +localStorageService.get("userName"))
			console.log("p-->" +localStorageService.get("password"))
			if(localStorageService.get("userName")!==null &&  localStorageService.get("password")!==null
					&& localStorageService.get("userName")!==undefined &&  localStorageService.get("password")!=undefined){
				
				OrderService.saveOrder($scope.cart,localStorageService.get("userName"),localStorageService.get("password")).then(
						function() {
							// $location.path('/products');
							$scope.productflag=true;
							//
							GlobalDataService.setCart($scope.cart);
							$scope.cart=[];
							localStorageService.set('cart', $scope.cart);
							GlobalDataService.setCart('cart',$scope.cart);
							//localStorageService.remove('cart');
							console.log("success----");
							$location.path('/successPayment'); 
							
						}, function(errorPayload) {
							$scope.error = errorPayload.message;
							console.log("error"+JSON.stringify($scope.error))
						});
			}
			else{
				$('#loginModal').modal('show'); 
				loginFunction();
				
			}
		};
		
		
		
		
		
		
		} ]);