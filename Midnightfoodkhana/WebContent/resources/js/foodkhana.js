var foodKhanaServicesModule = angular.module('foodkhana.services', [ 'ngResource',
		'ngCookies' ]);


var foodKhanaControllersModule = angular.module('foodKhana.controllers',
		[ 'foodkhana.services' ]);

foodKhanaControllersModule.controller('foodKhanaController', function($location) {

});

foodKhanaControllersModule.controller('HeaderController', [
		'$scope',
		'$location',
		'GlobalDataService',
		'$window',
		'localStorageService',
		
		function($scope, $location, GlobalDataService, $window,
				localStorageService) {
			
	
			$scope.onLoad = function() {
				$scope.userName = localStorageService.get('userName');
				$scope.cart=localStorageService.get('cart');

			};
			
			$scope.$watch(function() {
				return GlobalDataService.getAdmin();
			}, function(newValue, oldValue) {
				if (newValue !== oldValue)
					$scope.adminUser = newValue;

			});
			$scope.$watch(function() {
				return GlobalDataService.getCart();
			}, function(newValue, oldValue) {
				if (newValue !== oldValue)
					$scope.cart= newValue;

			});
			$scope.$watch(function() {
				return GlobalDataService.getName();
			}, function(newValue, oldValue) {
				if (newValue !== oldValue)
					$scope.userName = newValue;

				if ($scope.userName === undefined || $scope.userName === null) {
					$scope.accountHref = "#/myAccount";
				} else {
					$scope.accountHref = "#/userMain";
				}

			});

			/*
			 * $scope.authenticate = function() { if ($scope.userName ===
			 * undefined) { $scope.userName = GlobalDataService
			 * .getCookieDataForUser(); } };
			 */
			

			$scope.logOut = function() {
				GlobalDataService.clearData();
				localStorageService.remove('cart');
				localStorageService.remove('userName');

				$location.path('/home');
				$window.location.reload();

			};
			$scope.isActive = function(viewLocation) {

				return viewLocation === $location.path();
			};
		} ]);

var foodKhanaApp = angular.module('foodKhanaApp', [ 'ngRoute',
		'foodKhana.controllers', 'foodkhana.services', 'LocalStorageModule' ]);

foodKhanaApp.config(function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'partials/home.html',
		controller : 'HeaderController'
	}).when('/menu', {
		templateUrl : 'partials/menu.html',
		controller : 'MenuController'
	}).when('/foodCart', {
		templateUrl : 'partials/foodCart.html',
		controller : 'FoodCartController'
	}).when('/myAccount', {
		templateUrl : 'partials/account.html',
		controller : 'PersonController'
	}).when('/aboutUs', {
		templateUrl : 'partials/aboutus.html'
	}).when('/contact', {
		templateUrl : 'partials/contact.html'
	}).when('/userMain', {
		templateUrl : 'partials/userMain.html',
		controller : 'UserController'
	}).when('/adminMain', {
		templateUrl : 'partials/adminMain.html',
		controller : 'AdminController'
	}).when('/payment', {
		templateUrl : 'partials/payment.html',
		controller : 'PaymentController'
	}).when('/successPayment', {
		templateUrl : 'partials/successPayment.html',
	}).	
	otherwise({
		redirectTo : '/home'
	});
});

foodKhanaApp.config(function(localStorageServiceProvider) {
	localStorageServiceProvider.setStorageCookie(45, '/', false).setNotify(
			true, true);
})