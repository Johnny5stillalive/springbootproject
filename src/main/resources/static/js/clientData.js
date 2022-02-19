angular.module('clientAPP')
	.controller('clientController', function($scope, $http) {
		

		$scope.deleteClient = function(id) {
			var data = {
				id:id
			};
			
			var onPostSuccess = function(data, status, headers, config) {
			$scope.data = data;
			window.location.reload()
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
			window.location.reload()
		}
			
			//Call the services
			$http.post('/deleteClient', data)
				.success(onPostError)
				.error(onPostError);
		};
		
		$scope.addClient = function(name, address, contactInfo) {
			var data = 
			{
				name: name,
				adress: address,
				contactInfo: contactInfo
			};
			
			

			//Call the services
			$http.post('/addNewClient', data)
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