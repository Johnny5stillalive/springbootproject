angular.module('clientAPP')
	.controller('clientController', function($scope, $http) {
		var onPostSuccess = function(data, status, headers, config) {
			$scope.data = data;
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
		}

		$scope.deleteClient = function(id) {
			var data = {
				id: id
			};

			//Call the services
			$http.post('/deleteClient', data)
				.success(onPostSuccess)
				.error(onPostError);
		};


		var onGetSuccess = function(data, status, headers, config) {
			$scope.clients = data;
		};

		var onGetError = function(data, status, headers, config) {
			$scope.error = status;
		}

		$http.get('http://localhost:8080/getClientList').success(onGetSuccess).error(onGetError);
	});