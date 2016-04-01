'use strict';

App.factory('UserService', ['$http', '$q', function($http, $q){

	return {
		
			listUsers: function() {
					return $http.get('http://localhost:8080/simplecrudapp/user/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error listing users');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createUser: function(user){
					return $http.post('http://localhost:8080/simplecrudapp/user/', user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error creating user');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateUser: function(user, id){
					return $http.put('http://localhost:8080/simplecrudapp/user/'+id, user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error updating user');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteUser: function(id){
					return $http.delete('http://localhost:8080/simplecrudapp/user/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error deleting user');
										return $q.reject(errResponse);
									}
							);
			}
	};
}]);
