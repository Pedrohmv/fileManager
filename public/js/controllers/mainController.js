angular.module("filemanager").controller("main", function($scope, $http, $window){            
    $scope.logado = false;

    var isLogado = function(){
        $http.get("/api/auth").success(function (data){
            $scope.logado = JSON.parse(data);
        });
    }

    var inicio = function(){
        $http.get("/home").success(function(data) {

        });
    }
    $scope.login = function(user){
        $http.post("/api/login", user).success(function (data){
            console.log(data);
            $scope.usuario = data;
           $window.location.href = "/";
        });
    }

    $scope.addUser = function(user){
        $http.post("/api/user", user).success(function (data){
            $window.location.href = "/#login";
        });
    }

    $scope.logout = function(){
        $http.post("/api/logout").success(function (data){
            $window.location.href = "/";
        });
    }

   isLogado();
});