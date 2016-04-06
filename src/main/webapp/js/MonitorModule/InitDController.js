angular.module('MonitorModule').controller('InitDController',
    function($scope, $http, $sce) {
       $http.get("/host/init.d").success(function(response) {
             $scope.initd = response;
       });
});