var todoApp = angular.module('todoApp', ['ui.router','ngCookies']);

todoApp.config(function($stateProvider){

    var indexState = {
        name: "index",
        url: "/",
        templateUrl: "index.html",
        controller: "indexCtrl"
    };

    $stateProvider.state(indexState);

});

todoApp.factory('indexCtrl', ['$http', function($http) {
    var factory = {};

    factory.getTaskSet = function(token,callback){
        $http({
            method: 'GET',
            url: '/feed'
        }).then(function successCallback(response){
            callback(response)
        }, function errorCallback(err){
            console.log('Error: ' + err.data.error);
        });
    };

    return factory;
}]);
