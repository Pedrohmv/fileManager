angular.module("filemanager").config(function($routeProvider){

    $routeProvider.when("/", {
        templateUrl: "/assets/html/home.html"
    });

    $routeProvider.when("/login", {
        templateUrl: "/assets/html/login.html"
    });

    $routeProvider.when("/signup", {
        templateUrl: "/assets/html/signup.html"
    });

    $routeProvider.when("/signup", {
            templateUrl: "/assets/html/settings.html"
        });

});