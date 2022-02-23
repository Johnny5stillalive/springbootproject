

var app = angular.module('vendorsToClientAPP', []);
	app.controller('clientController', function($scope, $http, $location) {
		$scope.clientId = $location.absUrl().split("/").pop();
		
		var onGetClientSuccess = function(data, status, headers, config) {
			$scope.client = data;
			
			
		};

		var onGetClientError = function(data, status, headers, config) {
			$scope.error = status;
		}
	
	
	$http.get('http://localhost:8080/getClientById',{params:{id:$scope.clientId}}).success(onGetClientSuccess).error(onGetClientError);
		
			});