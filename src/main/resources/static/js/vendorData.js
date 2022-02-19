angular.module('vendorAPP')
	.controller('vendorController', function($scope, $http) {
		

		$scope.deleteVendor = function(id) {
			var data = {
				id:id
			};
			
			var onPostSuccess = function(data, status, headers, config) {
			$scope.data = data;
			window.location.reload()
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
			window.location.reload()
		}
			
			//Call the services
			$http.post('/deleteVendor', data)
				.success(onPostError)
				.error(onPostError);
		};
		
		$scope.addVendor = function(name, address, contactInfo) {
			var data = 
			{
				name: name,
				adress: address,
				contactInfo: contactInfo
			};
			
			

			//Call the services
			$http.post('/addNewVendor', data)
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