var app = angular.module('myAPP', []);

app.controller('MainCtrl', function($scope, $http, $location) {
	$scope.consultantId = $location.absUrl().split("/").pop();
	
	var onGetConsultantSuccess = function(data, status, headers, config) {
			$scope.consultant = data;
		};

		var onGetConsultantError = function(data, status, headers, config) {
			$scope.error = status;
		}
	
	
	$http.get('http://localhost:8080/getConsultantById',{params:{id:$scope.consultantId}}).success(onGetConsultantSuccess).error(onGetConsultantError);
	
	
	var onPostSuccess = function(data, status, headers, config) {
			$scope.data = data;
			window.location.reload()
		};

		var onPostError = function(data, status, headers, config) {
			$scope.error = status;
			window.location.reload()
		};
		
	$scope.addResume = function(consultantId, inputType, inputContent){
		var data = 
			{
				consultantID: consultantId,
				type: inputType,
				content: inputContent
			};
			
			

			//Call the services
			$http.post('/addResume', null,  {params:data})
				.success(onPostSuccess)
				.error(onPostError);
		};
		
		$scope.addSubmission = function(clientSelect, vendorSelect, inputDate){
			let date = JSON.stringify(inputDate)
date = date.slice(1,11)
			
		var data = 
			{
				resumeID: $scope.consultantId,
				date: date,
				vendorID: vendorSelect,
				clientID: clientSelect
			};
			
			

			//Call the services
			$http.post('/addResumeSubmission', null,  {params:data})
				.success(onPostSuccess)
				.error(onPostError);
		};
		
		$scope.deleteResume = function(id) {
			
			var data = {
				id:id
			};
			
			//Call the services
			$http.post('/deleteResume', null, {params:data})
				.success(onPostError)
				.error(onPostError);
		};
	
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
		
		var onGetResumeListSuccess = function(data, status, headers, config) {
			$scope.resumes = data;
		};

		var onGetResumeListError = function(data, status, headers, config) {
			$scope.error = status;
		}


		$http.get('http://localhost:8080/getResumeList').success(onGetResumeListSuccess).error(onGetResumeListError);
});