angular.module("filemanager").controller("home", function($scope, $http, $window){ 

    $scope.createFolderModal = false;
    $scope.createFileModal = false;
    $scope.previousFileShow = true;
    var stackAccess = [];

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
        uri = "/api/users/" + username + "/root/" + $scope.currentFolder.id + /folder/ + name;
        $http.get(uri).success(function (data){
             $scope.createFolderModal = false;
             updateData();  
        });
    }
    
    $scope.createFile = function(name){
        var username = $scope.userSession.username
        uri = "/api/users/" + username + "/root/" + $scope.currentFolder.id + /archive/ + name;
        $http.get(uri).success(function (data){
             $scope.createFileModal = false;
             updateData();  
        });
    }

    $scope.changeFolder = function(id){
        stackAccess.push(id);
        var username = $scope.userSession.username
        uri = "/api/users/" + username + "/root/" + stackAccess[stackAccess.length -1];
        console.log(stackAccess);
        console.log(uri);
         $http.get(uri).success(function (data){
             updateLocation(data);
        }); 

    }

    $scope.comeBack = function(){
        stackAccess.pop();
        var username = $scope.userSession.username;
        id = stackAccess[stackAccess.length -1];
        if (id == undefined)
            id = $scope.root.id;
        uri = "/api/users/" + username + "/root/" + id;
        console.log(stackAccess);
        console.log(uri);
        $http.get(uri).success(function (data){
             updateLocation(data);
        });
    }

    var updateData = function(){
        var username = $scope.userSession.username
        uri = "/api/users/" + username + "/root";
        $http.get(uri).success(function (data){
             $scope.root = data;
             $scope.currentFolder = data;
             $scope.currentFolderName = data.name;
        });
    }

    var updateLocation = function(folder){
        if(folder != undefined){
            $scope.previousFolder = $scope.currentFolder;
            $scope.currentFolder = folder;
            $scope.currentFolderName = folder.name;   
        }
    }

    updateData();    
    
});