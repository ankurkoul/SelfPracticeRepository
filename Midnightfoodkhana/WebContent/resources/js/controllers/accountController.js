/*var app=angular.module('foodKhana.controllers');

app.factory('Person', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/spring4-1/info/person/:personId', {personId: '@pid'},
	{
		updatePerson: {method: 'PUT'}
	}
    );
}]);
app.controller('PersonController', ['$scope', 'Person', function($scope, Person) {
	
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
	
	
    var ob = this;
    ob.persons=[];
    ob.person = new Person(); 
    ob.fetchAllPersons = function(){
        ob.persons = Person.query();
    };
    ob.fetchAllPersons();
    ob.addPerson = function(){
	console.log('Inside save');
	if($scope.personForm.$valid) {
	  ob.person.$save(function(person){
	     console.log(person); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllPersons();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editPerson = function(id){
	    console.log('Inside edit');
            ob.person = Person.get({ personId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updatePersonDetail = function(){
	console.log('Inside update');
	if($scope.personForm.$valid) {
    	   ob.person.$updatePerson(function(person){
    		console.log(person); 
		ob.updatedId = person.pid;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllPersons();
           });
	}
    };	
    ob.deletePerson = function(id){
	    console.log('Inside delete');
	    ob.person = Person.delete({ personId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllPersons(); 
	    });
    };		
    ob.reset = function(){
    	ob.person = new Person();
        $scope.personForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.person = new Person();
	    ob.flag= '';	
   	    ob.fetchAllPersons();
    };    
}]);    */