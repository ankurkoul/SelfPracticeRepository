angular.module('foodKhana.controllers').controller(
		'UserController',
		[
				'$scope',
				'AuthenticationService',
				'$location',
				'GlobalDataService',
				'OrderService',
				'localStorageService',
				function($scope, AuthenticationService, $location,
						GlobalDataService, OrderService, localStorageService) {
				
					$scope.userOrder=[];
					$scope.userProduct=[];
					$scope.orderFlag = false;
					var getOrderForUser = function() {

						OrderService.getOrderForUser(
								localStorageService.get("userName"),
								localStorageService.get("password")).then(
								function(payload) {

									$scope.order = payload.data;
									console.log("us order :" + JSON.stringify($scope.order));
									for(var i in  $scope.order){
										if($scope.order[i].productList!==undefined && $scope.order[i].productList.length	>0	){
											console.log("found");
											$scope.userOrder.push($scope.order[i]);
											console.log("s---->"+JSON.stringify($scope.order[i]));
										//	$scope.userProduct.push($scope.order[i].productList);
											console.log("p---->"+JSON.stringify($scope.order[i].productList));
										}
									}
									// $location.path('/products');
									$scope.orderFlag = true;

								}, function(errorPayload) {
									$scope.error = errorPayload.message;
								});

					};

					var loadUserData = function() {
						var promise = AuthenticationService.Login(
								localStorageService.get("userName"),
								localStorageService.get("password"));
						promise.then(function(payload) {
							// alert(JSON.stringify(payload.data));
							$scope.user = payload.data;
							console.log("us" + JSON.stringify($scope.user));
							getOrderForUser();
						}, function(error) {
							console.log("error")
						});

					}
					
					$scope.loadData = function() {
						loadUserData();
						
					};

				} ]);