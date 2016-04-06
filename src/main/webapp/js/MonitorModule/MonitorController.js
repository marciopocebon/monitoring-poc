angular.module('MonitorModule').controller('MonitorController',
    function($scope, $http, $sce) {
       $http.get("/host/cpuinfo").success(function(response) {
             $scope.monitor = response;
       });
});