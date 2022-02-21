var app = angular.module('myApp', []);

app.controller('MainCtrl', function($scope) {
	$scope.employees = [{ id: 1, type: "jack", content: "1234", submissions:[{name:"asdf"}] }, { id: 1, name: "jill", password: "12345", address: "32 Hill St", salary: 100001 }]

});