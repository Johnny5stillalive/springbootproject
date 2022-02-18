angular.module('clientApp', []).controller('clientController', function($scope, $http) {
    $http.get('http://localhost:8080/getClientList').
        then(function(response) {
            $scope.clients = response.data;
        });
});