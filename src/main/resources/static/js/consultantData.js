angular.module('consultantAPP')
	.controller('consultantController', function($scope, $http) {
		
var onPostSuccess = function(data, status, headers, config) {
			$scope.data = data;
			window.location.reload()
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
			window.location.reload()
		}
		
		$scope.deleteConsultant = function(id) {
			var data = {
				id:id
			};
			
			
			//Call the services
			$http.post('/deleteConsultant', null, {params:data})
				.success(onPostError)
				.error(onPostError);
		};
		
		$scope.addConsultant = function(inputName, inputAddress, inputContactInfo) {
			//alert(inputName + inputAddress);
			var data = 
			{
				name: inputName,
				address: inputAddress,
				contactInfo: inputContactInfo
			};
			
		
			//Call the services
			$http.post('/addNewConsultant', null, {params:data})
				.success(onPostSuccess)
				.error(onPostError);
		};


		var onGetSuccess = function(data, status, headers, config) {
			$scope.consultants = data;
		};

		var onGetError = function(data, status, headers, config) {
			$scope.error = status;
		}

		$http.get('http://localhost:8080/getConsultantList').success(onGetSuccess).error(onGetError);
	});