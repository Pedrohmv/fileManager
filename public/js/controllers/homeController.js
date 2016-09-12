angular.module("filemanager").controller("home", function($scope, $http, $window){ 

    $scope.createFolderModal = false;
    $scope.createFileModal = false;
    $scope.previousFileShow = true;
    $scope.fileShow = false;
    $scope.editView = false;
    $scope.folderShow = false;
    $scope.typeOfFile = ["txt", "md"];
    var stackAccess = [];
    $scope.currentFolderName = "/Root";

    $scope.openFolderWindow = function(){
        $scope.createFolderModal = true;
    }

    $scope.closeFolderWindow = function(){
        $scope.createFolderModal = false;
    }

    $scope.closeEditFolderView = function(){
        $scope.folderShow = false;
    }

    $scope.showRename = function(folder){
        $scope.folderShow = !$scope.folderShow;
        $scope.folderEdit = folder;
    }

    $scope.openFileWindow = function(){
        $scope.createFileModal = true;
        $scope.editView = false;
    }

    
    $scope.closeFileWindow = function(){
        $scope.createFileModal = false;
        $scope.editView = false;
    }

    $scope.closeFileView = function(){
        $scope.fileShow = false;
    }

    
    $scope.createFolder = function(name){
        var username = $scope.userSession.username
        uri = "/api/users/" + username + "/root/" + $scope.currentFolder.id + "/folder/" + name;
                $http.get(uri).success(function (data){
                     $scope.createFolderModal = false;
                     $scope.updateData();  
        });
    }
    
    $scope.createFile = function(file){
        var username = $scope.userSession.username;
        uri = "/api/users/" + username + "/root/" + $scope.currentFolder.id + "/archive";
        $http.post(uri, file).success(function (data){
             $scope.createFileModal = false;
             $scope.updateData();  
        });
    }

    $scope.editFile = function(file) {
        var username = $scope.userSession.username;
        uri = "/api/users/" + username + "/file/" + $scope.currentFile.id;
        $http.post(uri, file).success(function (data){
            $scope.createFileModal = false;
            $scope.updateData();
        });
    }

    $scope.changeFolder = function(id){
        stackAccess.push(id);
        var username = $scope.userSession.username;
        uri = "/api/users/" + username + "/root/" + stackAccess[stackAccess.length -1];
         $http.get(uri).success(function (data){
             $scope.updateData();
             $scope.currentFolderName = $scope.currentFolderName + "/" + data.name ;
        }); 

    }

    $scope.renameFolder = function(name){
        uri = "/api/users/" + username + "/root/" + $scope.currentFolder.id;
        $http.put(uri, name).success(function (data){
             $scope.updateData();
             $scope.currentFolderName = $scope.currentFolderName + "/" + data.name ;
        }); 

    }

    $scope.changeFile = function(id){
        var files = $scope.currentFolder.files;
        for(i in files){
            if(files[i].id == id){
                $scope.currentFile = files[i];
            }
        }
         
         $scope.fileShow = true;
        console.log($scope.currentFile);
    }

    $scope.changeSharedFile = function(id){
        var files = $scope.fileShared;
        for(i in files){
            if(files[i].id == id){
                $scope.currentFile = files[i];
            }
        }
         $scope.fileShow = true;
        console.log($scope.currentFile);
    }

    $scope.comeBack = function(){
        stackAccess.pop();
        var username = $scope.userSession.username;
        id = stackAccess[stackAccess.length -1];
        if (id == undefined)
            id = $scope.root.id;
        uri = "/api/users/" + username + "/root/" + id;
        $http.get(uri).success(function (data){
             $scope.updateData();
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

    $scope.updateData = function(){
        var username = $scope.userSession.username;
        
        if (stackAccess.length == 0)
            uri = "/api/users/" + username + "/root";
        else
            uri = "/api/users/" + username + "/root/" + stackAccess[stackAccess.length -1];
        $http.get(uri).success(function (data){
             $scope.root = data;
             $scope.currentFolder = data;
             getSharedFile();           

        });

        
    }

    var getSharedFile = function(){
        var username = $scope.userSession.username;
        uri = "/api/users/" + username + "/shared";
        $http.get(uri).success(function (data){
            $scope.fileShared = data;
        });
    }

    var updateLocation = function(folder){
        if(folder != undefined){
            $scope.previousFolder = $scope.currentFolder;
            $scope.currentFolder = folder;
            $scope.currentFolderName = folder.name;   
        }
    }

    $scope.updateData();    
    
});