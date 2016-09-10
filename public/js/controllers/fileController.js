angular.module("filemanager").controller("file", function($scope, $http, $window){            
    $scope.fileView = true;
    $scope.fileEdit = false;

    $scope.editFileView = function(){
        $scope.fileEdit = true;
        $scope.fileView = false;
    }


    $scope.close = function(){
        $scope.fileEdit = false;
        $scope.fileView = true;
        $scope.closeFileView();
    }

    $scope.cancel = function(){
        $scope.fileEdit = false;
        $scope.fileView = true;
    }
});