'use strict';

App.controller('UserController', [
		'$scope',
		'UserService',
		function($scope, UserService) {
			var self = this;
			self.user = {
				id : null,
				name : '',
				address : '',
				birth : '',
				email : ''
			};
			self.users = [];

			self.listUsers = function() {
				UserService.listUsers().then(function(d) {
					self.users = d;
				}, function(errResponse) {
					console.error('Error listUsers');
				});
			};

			self.createUser = function(user) {
				UserService.createUser(user).then(self.listUsers,
						function(errResponse) {
							console.error('Error creating User.');
						});
			};

			self.updateUser = function(user, id) {
				UserService.updateUser(user, id).then(self.listUsers,
						function(errResponse) {
							console.error('Error updating User.');
						});
			};

			self.deleteUser = function(id) {
				UserService.deleteUser(id).then(self.listUsers,
						function(errResponse) {
							console.error('Error deleting User.');
						});
			};

			self.listUsers();

			self.submit = function() {
				if (self.user.id == null) {
					console.log('Saving New User', self.user);
					self.createUser(self.user);
				} else {
					self.updateUser(self.user, self.user.id);
					console.log('User updated with id ', self.user.id);
				}
				self.reset();
			};

			self.edit = function(id) {
				console.log('id to be edited', id);
				for (var i = 0; i < self.users.length; i++) {
					if (self.users[i].id == id) {
						self.users[i].birth = new Date(self.users[i].birth);
						self.user = angular.copy(self.users[i]);
						break;
					}
				}
			};

			self.remove = function(id) {
				console.log('id to be deleted', id);
				if (self.user.id === id) {// clean form if the user to be
					// deleted is shown there.
					self.reset();
				}
				self.deleteUser(id);
			};

			self.reset = function() {
				self.user = {
					id : null,
					name : '',
					address : '',
					birth : '',
					email : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			};

		} ]);
