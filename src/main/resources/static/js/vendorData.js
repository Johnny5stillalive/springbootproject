angular.module('vendorAPP')
	.controller('vendorController', function($scope, $http) {
		
	var onPostSuccess = function(data, status, headers, config) {
			$scope.data = data;
			window.location.reload()
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
			window.location.reload()
		};

		$scope.deleteVendor = function(id) {
			var data = {
				id: id
			};
			
		
			//Call the services
			$http.post('/deleteVendor', null, {params:data})
				.success(onPostError)
				.error(onPostError);
		};
		
		$scope.addVendor = function(inputName, inputAddress, inputContactInfo) {
			var data = 
			{
				name: inputName,
				address: inputAddress,
				contactInfo: inputContactInfo
			};
			
			

			//Call the services
			$http.post('/addNewVendor', null,  {params:data})
				.success(onPostSuccess)
				.error(onPostError);
		};


		var onGetSuccess = function(data, status, headers, config) {
			$scope.vendors = data;
		};

		var onGetError = function(data, status, headers, config) {
			$scope.error = status;
		}

		$http.get('http://localhost:8080/getVendorList').success(onGetSuccess).error(onGetError);
	});