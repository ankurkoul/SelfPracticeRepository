angular
		.module('foodKhana.controllers')
		.controller(
				'PersonController',
				[
						'$scope',
						'AuthenticationService',
						'$location',
						'GlobalDataService',
						'localStorageService',
						function($scope, AuthenticationService, $location,
								GlobalDataService, localStorageService) {
							$scope.credentials = {};
							$scope.admin = {};
							/*
							 * $scope.login= function(){
							 * alert(JSON.stringify($scope.credentials));
							 * AuthenticationService.Login($scope.credentials.username,
							 * $scope.credentials.password, function (response) {
							 * if (response.success) {
							 * AuthenticationService.SetCredentials($scope.username,
							 * $scope.password); $location.path('/'); } else {
							 * $scope.error = response.message;
							 * $scope.dataLoading = false; } }; }
							 */
							$scope.personData = {};

							$scope.adminLogin = function() {
								$scope.dataLoading = true;
								var promise = AuthenticationService.AdminLogin(
										$scope.admin.userName,
										$scope.admin.password);
								promise
										.then(
												function(payload) {
													// alert(JSON.stringify(payload.data));
													$scope.personData = payload.data;
													$scope.credentials = $scope.admin;
													GlobalDataService
															.setName($scope.credentials.userName);
													GlobalDataService
															.setUserObject($scope.personData);
													GlobalDataService.setAdmin($scope.credentials.userName);
													GlobalDataService
															.setCookieDataForUser($scope.credentials.userName);
													localStorageService
															.set(
																	'userName',
																	$scope.credentials.userName);
													localStorageService
															.set(
																	'password',
																	$scope.credentials.password);

												
													$(function() {
														$('#adminModal').modal(
																'toggle');
													});

													$location.path('/adminMain');
												},
												function(errorPayload) {
												console.log(errorPayload);
													$scope.adminError = errorPayload.message;
													$scope.dataLoading = false;

													// $log.error('failure
													// loading movie',
													// errorPayload);
												});
								/*
								 * AuthenticationService.Login($scope.credentials.username,
								 * $scope.credentials.password, function
								 * (response) { alert(0) if (response.success) {
								 * alert("success");
								 * AuthenticationService.SetCredentials($scope.credentials.username,
								 * $scope.credentials.password);
								 * $location.path('/home'); } else {
								 * $scope.error = response.message;
								 * $scope.dataLoading = false; } }
								 */
								// );
							};
							$scope.login = function() {
								$scope.dataLoading = true;
								var promise = AuthenticationService.Login(
										$scope.credentials.userName,
										$scope.credentials.password);
								promise
										.then(
												function(payload) {
													// alert(JSON.stringify(payload.data));
													$scope.personData = payload.data;
													GlobalDataService
															.setName($scope.credentials.userName);
													GlobalDataService
													.setUserObject($scope.personData);
													GlobalDataService
															.setCookieDataForUser($scope.credentials.userName);
													localStorageService
															.set(
																	'userName',
																	$scope.credentials.userName);
													localStorageService
													.set(
															'password',
															$scope.credentials.password);
													$location.path('/userMain');
												},
												function(errorPayload) {
													console.log(errorPayload);
													$scope.error = errorPayload.message;
													$scope.dataLoading = false;

													// $log.error('failure
													// loading movie',
													// errorPayload);
												});
								/*
								 * AuthenticationService.Login($scope.credentials.username,
								 * $scope.credentials.password, function
								 * (response) { alert(0) if (response.success) {
								 * alert("success");
								 * AuthenticationService.SetCredentials($scope.credentials.username,
								 * $scope.credentials.password);
								 * $location.path('/home'); } else {
								 * $scope.error = response.message;
								 * $scope.dataLoading = false; } }
								 */
								// );
							};
							$scope.signup = function() {
								// alert(JSON.stringify($scope.credentials));
								var promise = AuthenticationService
										.Signup($scope.credentials);
								promise
										.then(
												function(payload) {
													// alert(JSON.stringify(payload.data));
													$scope.personData = payload.data;
													GlobalDataService
															.setName($scope.credentials.userName);
													GlobalDataService
													.setUserObject($scope.personData);
													localStorageService
															.set(
																	'userName',
																	$scope.credentials.userName);
													localStorageService
															.set(
																	'pass',
																	$scope.credentials.password);
													$location.path('/userMain');
												},
												function(errorPayload) {
													alert("error	"
															+ JSON
																	.stringify(errorPayload));
													$scope.error = errorPayload.message;
													$scope.dataLoading = false;

													// $log.error('failure
													// loading movie',
													// errorPayload);
												});

							};

							$scope.remove = function() {
								// alert(JSON.stringify($scope.credentials));
								var promise = AuthenticationService
										.Remove($scope.credentials.id);
								promise.then(function(payload) {
									// alert(JSON.stringify(payload.data));
									$location.path('/home');
								}, function(errorPayload) {
									// alert(errorPayload);
									$scope.error = errorPayload.message;
									$scope.dataLoading = false;

									// $log.error('failure loading movie',
									// errorPayload);
								});

							};

							$scope.findAll = function() {
								// alert(JSON.stringify($scope.credentials));
								var promise = AuthenticationService.FindAll();
								promise.then(function(payload) {
									// alert(JSON.stringify(payload.data));
									$location.path('/home');
								}, function(errorPayload) {
									// alert(errorPayload);
									$scope.error = errorPayload.message;
									$scope.dataLoading = false;

									//  $log.error('failure loading movie', errorPayload);
								});

							};
							$scope.sendEmail = function() {
								console.log(JSON.stringify($scope.credentials));
							};

							/*$scope.logout = function() {
								GlobalService.clearCredentials();
							}*/

						} ]);