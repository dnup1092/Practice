/*var app = angular.module('demo', ['ui.bootstrap','ui.utils']);
app.controller('Hello', function($scope), $http) {
    $http.get('http://localhost:8080/EnterpriseUIRestServices/').
        then(function(response) {
            $scope.greeting = response.data;
        });{

});



*/

//Angularjs and jquery.datatable with ui.bootstrap and ui.utils

var app=angular.module('demo', ['ui.bootstrap','ui.utils']);
app.controller('Hello',function($scope,$http) {
    $http.get('http://localhost:8080/EnterpriseUIRestServices/').
    then(function(response) {
  
    	$scope.data= response.data;

$scope.dataTableOpt = {
   //custom datatable options 
  // or load data through ajax call also
  "aLengthMenu": [[10, 50, 100,-1], [10, 50, 100,'All']],
  }; });
});