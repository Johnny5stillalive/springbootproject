

var app = angular.module('clientsToVendorAPP', []);
	app.controller('vendorController', function($scope, $http, $location) {
		$scope.vendorId = $location.absUrl().split("/").pop();
		
		var onGetVendorSuccess = function(data, status, headers, config) {
			$scope.vendor = data;
			
			
		};

		var onGetVendorError = function(data, status, headers, config) {
			$scope.error = status;
		}
	
	
	$http.get('http://localhost:8080/getVendorById',{params:{id:$scope.vendorId}}).success(onGetVendorSuccess).error(onGetVendorError);
		
		var onGetSuccess = function(data, status, headers, config) {
			$scope.clients = data;
		};

		var onGetError = function(data, status, headers, config) {
			$scope.error = status;
		}

		$http.get('http://localhost:8080/getClientListByVendorId',{params:{id:$scope.vendorId}}).success(onGetSuccess).error(onGetError);
		
		
		
			});