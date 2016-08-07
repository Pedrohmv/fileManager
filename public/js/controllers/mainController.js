angular.module("filemanager").controller("main", function($scope, $http, $window){            
    $scope.logado = false;
    $scope.userSession = localStorage.getItem("user");
    $scope.userSession = JSON.parse($scope.userSession);

    var isLogado = function(){
        if($scope.userSession == null)
            var user = { };
        else
            var user = { email: $scope.userSession.email, password: $scope.userSession.password };

        console.log(user);
        $http.post("/api/auth", user).success(function (data){
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
            localStorage.setItem("user", JSON.stringify(data));
            console.log($scope.usuario);
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
            $window.location.href = "/";
        });
    }

   isLogado();
});