angular.module("filemanager").controller("file", function($scope, $http, $window){            
    $scope.fileView = true;
    $scope.fileEdit = false;
    $scope.fileShare = false;

    $scope.editFileView = function(){
        $scope.fileEdit = true;
        $scope.fileView = false;
    }

    $scope.shareFileView = function(){
        $scope.fileShare = true;
        $scope.fileEdit = false;
        $scope.fileView = false;
    }

    $scope.cancelShare = function(){
        $scope.fileView = true;
        $scope.fileShare = false;
        $scope.fileEdit = false;
        
    }

    $scope.cancel = function(){
        $scope.fileView = true;
        $scope.fileEdit = false;
        $scope.fileShare = false;
    }


    $scope.close = function(){
        $scope.cancel();
        $scope.closeFileView();
    }

    $scope.shareFile = function(friend){
        var username = $scope.userSession.username
        uri = "/api/users/" + username + "/file/" + $scope.currentFile.id + "/share/" + friend;
        $http.get(uri).success(function (data){
            $scope.createFolderModal = false;
            $scope.updateData();
            $scope.close();  
        });
    }

    $scope.editFile = function(newFile){
        var username = $scope.userSession.username;
        uri = "/api/users/" + username + "/file/" + $scope.currentFile.id;
        console.log(uri);
        console.log(newFile);
        $http.put(uri, newFile).success(function (data){
             $scope.createFolderModal = false;
             $scope.updateData();
             $scope.close();
             newFile = null;  
        });
    }

    
});