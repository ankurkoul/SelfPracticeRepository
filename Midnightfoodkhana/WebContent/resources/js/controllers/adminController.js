angular.module('foodKhana.controllers').controller(
		'AdminController',
		[
				'$scope',
				'AuthenticationService',
				'$location',
				'GlobalDataService',
				function($scope, AuthenticationService, $location,
						GlobalDataService) {
					$scope.user = GlobalDataService.getUserObject();
					console.log("us"+JSON.stringify($scope.user))
				} ]);