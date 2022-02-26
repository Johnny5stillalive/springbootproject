

var app = angular.module('consultantsToVendorAPP', []);
	app.controller('vendorController', function($scope, $http, $location) {
		$scope.vendorId = $location.absUrl().split("/").pop();
		
		
		
		$scope.addConsultantRelationship = function(consultantId, vendorId) {
			
			var onPostSuccess = function(data, status, headers, config) {
			$scope.message = "Consultant added";
			window.location.reload()
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
			$scope.message = "Consultant failed to be added";
			window.location.reload()
		};
			var data = {
				consultantID: consultantId,
				vendorID: vendorId
			};
			
			//Call the services
			$http.post('/addConsultantToVendorRelationship', null, {params:data})
				.success(onPostError)
				.error(onPostError);
		};
		
		var onGetVendorSuccess = function(data, status, headers, config) {
			$scope.vendor = data;
			
			
		};

		var onGetVendorError = function(data, status, headers, config) {
			$scope.error = status;
		}
	
	
	$http.get('http://localhost:8080/getVendorById',{params:{id:$scope.vendorId}}).success(onGetVendorSuccess).error(onGetVendorError);
		
		var onGetSuccess = function(data, status, headers, config) {
			$scope.consultantsById = data;
		};

		var onGetError = function(data, status, headers, config) {
			$scope.error = status;
		}

		$http.get('http://localhost:8080/getConsultantListByVendorId',{params:{id:$scope.vendorId}}).success(onGetSuccess).error(onGetError);
		
		var onGetSuccess = function(data, status, headers, config) {
			$scope.consultants = data;
		};

		var onGetError = function(data, status, headers, config) {
			$scope.error = status;
		}

		$http.get('http://localhost:8080/getConsultantList').success(onGetSuccess).error(onGetError);
		
});