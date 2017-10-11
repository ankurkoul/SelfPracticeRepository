/*
var app=angular.module('foodKhana.controllers', []);

app.factory('Person', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/spring4-1/info/person/:personId', {personId: '@pid'},
	{
		updatePerson: {method: 'PUT'}
	}
    );
}]);
app.controller('PersonController', ['$scope','$rootScope' ,'Person', function($scope,$rootScope, Person) {
	
}

var app=angular.module('foodKhana.controllers', ['foodKhana.service']);
app.controller('PersonController', ['$scope', 'AccountService', function($scope, accountService) {
	
	$scope.credentials={};
	$scope.login= function(){
		alert(JSON.stringify($scope.credentials));	
	};
	
$scope.signup= function(){
	alert(JSON.stringify($scope.credentials));
	};
	
	
$scope.sendEmail= function(){
	alert(JSON.stringify($scope.credentials));
	};
	
}]);*/