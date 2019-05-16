var PolyNet = angular.module('PolyNet', ['ui.router','ngCookies', 'ngAnimate', 'ngSanitize', 'ui.bootstrap']);


PolyNet.config(function($stateProvider){

    var indexState = {
        name: "index",
        url: "/",
        templateUrl: "index.html",
        controller: "indexCtrl"
    };

    var modalState = {
        name: "modal",
        url: "/",
        templateUrl: "index.html",
        controller: "ModalDemoCtrl"
    };


    $stateProvider.state(indexState);
    $stateProvider.state(modalState);

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
            console.log('Error: ' + err);
        });
    };

    factory.share = function(data, callback) {
        var story = {
            content : data.content
        };
        var requete = {
            method: 'POST',
            url: '/share',
            data: story
        };
        $http(requete).then(function  successCallback(response){
            callback(response)
        }, function errorCallback(err){
            console.log('Error: ' + err);
        });
    };

    factory.moreStory = function(id, callback) {
        var story = {
            "id": id
        };
        var requete = {
            method: 'POST',
            url: '/commentStory',
            data: story
        };

        $http(requete).then(function  successCallback(response){
            callback(response)
        }, function errorCallback(err){
            console.log('Error: ' + err);
        });
    };

    factory.getStory = function(id, callback) {
        var story = {
            "id": id
        };
        var requete = {
            method: 'POST',
            url: '/story',
            data: story
        };

        $http(requete).then(function  successCallback(response){
            callback(response.data.content)
        }, function errorCallback(err){
            console.log('Error: ' + err);
        });
    };

    return factory;
}]);

PolyNet.controller('indexCtrl',
            ['$cookies','$scope', '$state', 'indexFactory', '$uibModal', '$log',
        function($cookies,$scope,$state,indexFactory, $uibModal, $log){
    $scope.liste_donnee = {};
    $scope.selectedStory = {};
    $scope.fullContentStory = {};

    $scope.getFeed = function() {
        indexFactory.getFeed(function (response) {
            $scope.liste_donnee = response.data;
        });
    };

    $scope.shareStory = function(){
        var content = {
            "content": $scope.contentStory
        };
        indexFactory.share(content, function(){
            $scope.getFeed();
            $scope.contentStory = '';
        });
    };

    $scope.moreStory = function(id) {
        indexFactory.getStory(id, function(response){
            console.log(response);
            $scope.selectedStory = response;
        });

        indexFactory.moreStory(id, function(response) {
            $scope.allComment = response.data;
            console.log($scope.allComment);
            var modalInstance = $uibModal.open({
                animation: true,
                component: 'modalComponent',
                resolve: {
                    story: function () {
                        return $scope.selectedStory;
                    },
                    items: function () {
                        return $scope.allComment;
                    }
                }
            });

            modalInstance.result.then(function () {
               //nothing
            }, function () {
                $log.info('modal-component dismissed at: ' + new Date());
            });
        })
    };
    $scope.getFeed();

}]);


PolyNet.component('modalComponent', {
    templateUrl: 'myModalContent.html',
    bindings: {
        resolve: '<',
        close: '&',
        dismiss: '&'
    },
    controller: function () {
        var $ctrl = this;

        $ctrl.$onInit = function () {
            $ctrl.allComment = $ctrl.resolve.items;
            $ctrl.story = $ctrl.resolve.story;
        };

        $ctrl.cancel = function () {
            $ctrl.dismiss({$value: 'cancel'});
        };

        $ctrl.ok = function () {
            $ctrl.story  = '';
            $ctrl.close();
        };
    }
});

