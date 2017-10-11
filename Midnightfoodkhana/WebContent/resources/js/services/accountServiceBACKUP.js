var app = angular.module('foodkhana.services', [ 'ngResource' ]);
/*app.factory('AccountService', [ '$resource', function($resource) {
	return {
		login : $resource('/user/login/:personId', {}, {
			query : {
				method : 'GET',
				params : {
					personId : '@id'
				},
				isArray : false
			},
			update : {
				method : 'POST',
				params : {
					personId : '@id'
				}
			}

		}),
		getAllUsers : $resource('/AllUsers', {}, {
			query : {
				method : 'GET',
				isArray : true
			}
		})

	};

} ]);
app.factory('UserNameService', function($resource) {
	var name = {};

	return {

		getName : function() {
			return name;

		},
		setName : function(value) {  
			name = value;
		}

	};
});*/