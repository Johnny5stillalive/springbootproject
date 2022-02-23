var app = angular.module('myAPP', []);

app.controller('MainCtrl', function($scope, $http, $location) {
	$scope.clientId = $location.absUrl().split("/").pop();
	
	var onPostSuccess = function(data, status, headers, config) {
			$scope.Message = "Client Up Dated";
			window.location.reload()
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
			window.location.reload()
		};
	
	$scope.updateClient = function(clientId, inputName, inputAddress, inputContactInfo) {
			
			var data = 
			{
				id: clientId,
				name: inputName,
				address: inputAddress,
				contactInfo: inputContactInfo
			};
			

			//Call the services
			$http.post('/updateClient', null, {params:data})
				.success(onPostSuccess)
				.error(onPostError);
		};
	
	var onGetClientSuccess = function(data, status, headers, config) {
			$scope.client = data;
			$scope.inputName = data.name;
			$scope.inputAddress = data.address;
			$scope.contactInfo = data.contactInfo;
			
		};

		var onGetClientError = function(data, status, headers, config) {
			$scope.error = status;
		}
	
	
	$http.get('http://localhost:8080/getClientById',{params:{id:$scope.clientId}}).success(onGetClientSuccess).error(onGetClientError);
	
	
	});