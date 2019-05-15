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

todoApp.factory('indexFactory', ['$http', function($http) {
    var factory = {};

    factory.getFeed = function(callback){
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

todoApp.controller('indexCtrl',
    ['$cookies','$scope', '$state', 'indexFactory', function($cookies,$scope,$state,indexFactory){
    $scope.liste_donnee = {};
    $scope.userR = {};
    $scope.errorData = {};

    indexFactory.getFeed(function (response) {
        $scope.liste_donnee = response.data;
    });
    $scope.refreshTaskSet = function () {

    }

}]);



