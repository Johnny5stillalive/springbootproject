var app = angular.module('myAPP', []);

app.controller('MainCtrl', function($scope, $http, $location) {
	$scope.consultantId = $location.absUrl().split("/").pop();
	
	$scope.resumes = [{ id: 1, type: "jack", content: "1234", submissions:[{name:"asdf"}] },  { id: 2, type: "jack", content: "1234", submissions:[{name:"asdf"}] }]


	var onGetClientSuccess = function(data, status, headers, config) {
			$scope.clientsList = data;
		};

		var onGetClientError = function(data, status, headers, config) {
			$scope.error = status;
		}

		$http.get('http://localhost:8080/getClientList').success(onGetClientSuccess).error(onGetClientError);
		
		var onGetVendorSuccess = function(data, status, headers, config) {
			$scope.vendorList = data;
		};

		var onGetVendorError = function(data, status, headers, config) {
			$scope.error = status;
		}

		$http.get('http://localhost:8080/getVendorList').success(onGetVendorSuccess).error(onGetVendorError);
});