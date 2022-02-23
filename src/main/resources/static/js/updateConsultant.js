var app = angular.module('myAPP', []);

app.controller('MainCtrl', function($scope, $http, $location) {
	$scope.consultantId = $location.absUrl().split("/").pop();
	
	var onPostSuccess = function(data, status, headers, config) {
			$scope.Message = "Consultant Up Dated";
			window.location.reload()
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
			window.location.reload()
		};
	
	$scope.updateConsultant = function(consultantId, inputName, inputAddress, inputContactInfo) {
			
			var data = 
			{
				id: consultantId,
				name: inputName,
				address: inputAddress,
				contactInfo: inputContactInfo
			};
			

			//Call the services
			$http.post('/updateConsultant', null, {params:data})
				.success(onPostSuccess)
				.error(onPostError);
		};
	
	var onGetConsultantSuccess = function(data, status, headers, config) {
			$scope.consultant = data;
			$scope.inputName = data.name;
			$scope.inputAddress = data.address;
			$scope.contactInfo = data.contactInfo;
			
		};

		var onGetConsultantError = function(data, status, headers, config) {
			$scope.error = status;
		}
	
	
	$http.get('http://localhost:8080/getConsultantById',{params:{id:$scope.consultantId}}).success(onGetConsultantSuccess).error(onGetConsultantError);
	
	
	});