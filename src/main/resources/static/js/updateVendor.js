var app = angular.module('myAPP', []);

app.controller('MainCtrl', function($scope, $http, $location) {
	$scope.vendorId = $location.absUrl().split("/").pop();
	
	var onPostSuccess = function(data, status, headers, config) {
			$scope.Message = "Vendor Up Dated";
			window.location.reload()
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
			window.location.reload()
		};
	
	$scope.updateVendor = function(vendorId, inputName, inputAddress, inputContactInfo) {
			
			var data = 
			{
				id: vendorId,
				name: inputName,
				address: inputAddress,
				contactInfo: inputContactInfo
			};
			

			//Call the services
			$http.post('/updateVendor', null, {params:data})
				.success(onPostSuccess)
				.error(onPostError);
		};
	
	var onGetVendorSuccess = function(data, status, headers, config) {
			$scope.vendor = data;
			$scope.inputName = data.name;
			$scope.inputAddress = data.address;
			$scope.contactInfo = data.contactInfo;
			
		};

		var onGetVendorError = function(data, status, headers, config) {
			$scope.error = status;
		}
	
	
	$http.get('http://localhost:8080/getVendorById',{params:{id:$scope.vendorId}}).success(onGetVendorSuccess).error(onGetVendorError);
	
	
	});