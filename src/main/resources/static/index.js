var PolyNet = angular.module('PolyNet', ['ui.router','ngCookies']);

PolyNet.config(function($stateProvider){

    var indexState = {
        name: "index",
        url: "/",
        templateUrl: "index.html",
        controller: "indexCtrl"
    };

    $stateProvider.state(indexState);

});

PolyNet.factory('indexFactory', ['$http', function($http) {
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

    factory.share = function(content, callback) {
        $http({
            method: 'POST',
            url: '/share',
            data: content
        }).then(function  successCallback(response){
            callback(response)
        }, function errorCallback(err){
            console.log('Error: ' + err.data.error);
        });
    };

    return factory;
}]);

PolyNet.controller('indexCtrl',
    ['$cookies','$scope', '$state', 'indexFactory', function($cookies,$scope,$state,indexFactory){
    $scope.liste_donnee = {};

    $scope.getFeed = function() {
        indexFactory.getFeed(function (response) {
            $scope.liste_donnee = response.data;
        });
    };

    $scope.shareStory = function(){
        var content = $scope.contentStory;
        console.log(content);
        indexFactory.share(content, function(){
            $scope.getFeed();
            $scope.contentStory = '';
        });
    };

    $scope.getFeed();

}]);



