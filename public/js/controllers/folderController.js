angular.module("filemanager").controller("folder", function($scope, $http, $window){            
    $scope.editFolder = function(folderName, folder){
        var username = $scope.userSession.username
        uri = "/api/users/" + username + "/root/" + folder.id;
                $http.put(uri, folderName).success(function (data){
                     $scope.createFolderModal = false;
                     $scope.updateData();
                     $scope.closeEditFolderView();
        });
    }
});