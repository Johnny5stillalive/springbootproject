angular.module('clientAPP')
	.controller('clientController', function($scope, $http) {
		
var onPostSuccess = function(data, status, headers, config) {
			$scope.data = data;
			window.location.reload()
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
			window.location.reload()
		};

		$scope.deleteClient = function(id) {
			
			var data = {
				id:id
			};
			
			//Call the services
			$http.post('/deleteClient', null, {params:data})
				.success(onPostError)
				.error(onPostError);
		};
		
		$scope.addClient = function(inputName, inputAddress, inputContactInfo) {
			
			var data = 
			{
				name: inputName,
				address: inputAddress,
				contactInfo: inputContactInfo
			};
			

			//Call the services
			$http.post('/addNewClient', null, {params:data})
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