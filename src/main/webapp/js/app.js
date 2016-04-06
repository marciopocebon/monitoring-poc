angular.module('app', ['ngRoute', 'MonitorModule']).
config(function ($routeProvider, $sceDelegateProvider) {
    $routeProvider.when('/', {
        templateUrl: 'partials/monitor.html',
        controller: 'MonitorController'
    });

    $routeProvider.when('/init.d', {
            templateUrl: 'partials/initd.html',
            controller: 'InitDController'
        });

    $routeProvider.otherwise({
        redirectTo: '/'
    });
});

angular.module('MonitorModule', []);