angular.module('consultantAPP')
	.controller('consultantController', function($scope, $http) {
		

		$scope.deleteConsultant = function(id) {
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
			$http.post('/deleteConsultant', data)
				.success(onPostError)
				.error(onPostError);
		};
		
		$scope.addConsultant = function(name, address, contactInfo) {
			var data = 
			{
				name: name,
				adress: address,
				contactInfo: contactInfo
			};
			
			

			//Call the services
			$http.post('/addNewConsultant', data)
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