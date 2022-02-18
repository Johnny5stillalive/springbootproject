angular.module('clientAPP')
	.controller('clientController', function($scope, $http) {
		$scope.deleteClient = function(id) {
			var data = {
				id: id
			};

			//Call the services

			$http.post('http://localhost:8080/deleteClient', JSON.stringify(data)).then(function(response) {

				if (response.data)

					$scope.msg = "Client" + id + " deleted !";

			}, function(response) {

				$scope.msg = "Client delete failed";

			});

		};

	

$http.get('http://localhost:8080/getClientList').
	then(function(response) {
		$scope.clients = response.data;
	});
		});