

var app = angular.module('vendorsToConsultantAPP', []);
	app.controller('consultantController', function($scope, $http, $location) {
		$scope.consultantId = $location.absUrl().split("/").pop();
		
		var onGetConsultantSuccess = function(data, status, headers, config) {
			$scope.consultant = data;
			
			
		};

		var onGetConsultantError = function(data, status, headers, config) {
			$scope.error = status;
		}
	
	
	$http.get('http://localhost:8080/getConsultantById',{params:{id:$scope.consultantId}}).success(onGetConsultantSuccess).error(onGetConsultantError);
		
		var onGetSuccess = function(data, status, headers, config) {
			$scope.vendors = data;
		};

		var onGetError = function(data, status, headers, config) {
			$scope.error = status;
		}

		$http.get('http://localhost:8080/getVendorListByConsultantId',{params:{id:$scope.consultantId}}).success(onGetSuccess).error(onGetError);
		
			});