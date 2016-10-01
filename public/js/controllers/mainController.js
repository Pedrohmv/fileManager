angular.module("filemanager").controller("main", function($scope, $http, $window){            
    $scope.logado = false;
    $scope.userSession = JSON.parse(localStorage.getItem("user"));
    $scope.sessionToken = JSON.parse(localStorage.getItem("sessionToken"));    

    var isLogado = function(){
        if($scope.sessionToken == null)
            var token = { token: 0};
        else
            var token = { token: $scope.sessionToken};

        $http.post("/api/auth", token).success(function (data){
             $scope.logado = JSON.parse(data);
        });
    }

    var inicio = function(){
        $http.get("/home").success(function(data) {

        });
    }

    $scope.login = function(user){
        $http.post("/api/login", user).success(function (data){
            localStorage.setItem("user", JSON.stringify(data.userSession));
            localStorage.setItem("sessionToken", JSON.stringify(data.token));
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
            localStorage.removeItem("user");
            localStorage.removeItem("sessionToken");
            $window.location.href = "/";
        });
    }

   isLogado();
});