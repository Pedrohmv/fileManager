angular.module("filemanager").controller("home", function($scope, $http, $window){ 

    $scope.createFolderModal = false;
    $scope.createFileModal = false;

    $scope.openFolderWindow = function(){
        $scope.createFolderModal = true;
    }

    $scope.closeFolderWindow = function(){
        $scope.createFolderModal = false;
    }

    $scope.openFileWindow = function(){
        $scope.createFileModal = true;
    }

    $scope.closeFileWindow = function(){
        $scope.createFileModal = false;
    }


    $scope.createFolder = function(name){
        var username = $scope.userSession.username
        uri = "/api/users/" + username + "/root/" + $scope.currentFolder + /folder/ + name;
        console.log(uri);
        $http.get(uri).success(function (data){
             $scope.createFolderModal = false;
             updateData();  
        });
    }
    
    $scope.createFile = function(name){
        var username = $scope.userSession.username
        uri = "/api/users/" + username + "/root/" + $scope.currentFolder + /archive/ + name;
        console.log(uri);
        $http.get(uri).success(function (data){
             $scope.createFileModal = false;
             updateData();  
        });
    }

    var updateData = function(){
        var username = $scope.userSession.username
        uri = "/api/users/" + username + "/root";
        $http.get(uri).success(function (data){
             $scope.root = data;
             $scope.currentFolder = $scope.root.id;
             $scope.currentFolderName = $scope.root.name;
        });
    }

    updateData();  
});