angular.module("filemanager").controller("home", function($scope, $http, $window){ 

    $scope.createFolderModal = false;
    $scope.createFileModal = false;
    $scope.previousFileShow = true;
    var stackAccess = [];
    $scope.currentFolderName = "/Root";

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
        uri = "/api/users/" + username + "/root/" + $scope.currentFolder.id + "/folder/" + name;
                $http.get(uri).success(function (data){
                     $scope.createFolderModal = false;
                     updateData();  
        });
    }
    
    $scope.createFile = function(file){
        var username = $scope.userSession.username;
        uri = "/api/users/" + username + "/root/" + $scope.currentFolder.id + "/archive";
        $http.post(uri, file).success(function (data){
             $scope.createFileModal = false;
             updateData();  
        });
    }

    $scope.changeFolder = function(id){
        stackAccess.push(id);
        var username = $scope.userSession.username;
        uri = "/api/users/" + username + "/root/" + stackAccess[stackAccess.length -1];
         $http.get(uri).success(function (data){
             updateData();
             $scope.currentFolderName = $scope.currentFolderName + "/" + data.name ;
        }); 

    }

    $scope.changeFile = function(id){
        var files = $scope.currentFolder.files
        for(i in files){
            if(files[i].id == id){
                $scope.currentFile = files[i];
            }
        }
        $window.location.href = "/#/file";
    }

    $scope.comeBack = function(){
        stackAccess.pop();
        var username = $scope.userSession.username;
        id = stackAccess[stackAccess.length -1];
        if (id == undefined)
            id = $scope.root.id;
        uri = "/api/users/" + username + "/root/" + id;
        $http.get(uri).success(function (data){
             updateData();
             var folders = $scope.currentFolderName.split('/');
             if(folders.length > 2){
                folders.pop();
                var path = folders.join('/');
                $scope.currentFolderName = path;
             }
             else{
                $scope.currentFolderName = "/Root";
             }
                
        });
    }

    var updateData = function(){
        var username = $scope.userSession.username;
        if (stackAccess.length == 0)
            uri = "/api/users/" + username + "/root";
        else
            uri = "/api/users/" + username + "/root/" + stackAccess[stackAccess.length -1];
        $http.get(uri).success(function (data){
             $scope.root = data;
             $scope.currentFolder = data;
             
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