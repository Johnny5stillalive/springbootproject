

var app = angular.module('clientsToVendorAPP', []);
app.controller('vendorController', function($scope, $http, $location) {
	$scope.vendorId = $location.absUrl().split("/").pop();


$scope.addClientRelationship = function(clientId, vendorId) {
			var onPostSuccess = function(data, status, headers, config) {
			$scope.message = "Client added";
			window.location.reload()
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
			$scope.message = "Client failed to be added";
			window.location.reload()
		};
			var data = {
				clientID: clientId,
				vendorID: vendorId
			};
			
			//Call the services
			$http.post('/addClientToVendorRelationship', null, {params:data})
				.success(onPostError)
				.error(onPostError);
		};

	var onGetVendorSuccess = function(data, status, headers, config) {
		$scope.vendor = data;


	};

	var onGetVendorError = function(data, status, headers, config) {
		$scope.error = status;
	}


	$http.get('http://localhost:8080/getVendorById', { params: { id: $scope.vendorId } }).success(onGetVendorSuccess).error(onGetVendorError);

	var onGetSuccess = function(data, status, headers, config) {
		$scope.clients = data;
	};

	var onGetError = function(data, status, headers, config) {
		$scope.error = status;
	}

	$http.get('http://localhost:8080/getClientListByVendorId', { params: { id: $scope.vendorId } }).success(onGetSuccess).error(onGetError);




	var onGetClientSuccess = function(data, status, headers, config) {
		$scope.clientsList = data;
	};

	var onGetClientError = function(data, status, headers, config) {
		$scope.error = status;
	}

	$http.get('http://localhost:8080/getClientList').success(onGetClientSuccess).error(onGetClientError);

	
});