var VLogin = angular.module('starter', ['ionic']);

VLogin.controller('LoginCtrl', ['$scope','$location', function($scope, $location) {

    $scope.login = function(){   
   // alert("Success!");

    $location.path("#/../home.html");
 };

}]);