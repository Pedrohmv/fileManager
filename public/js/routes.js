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

    $routeProvider.when("/settings", {
            templateUrl: "/assets/html/settings.html"
        });

    $routeProvider.when("/home", {
                 templateUrl: "/assets/html/home.html"
             });

    $routeProvider.when("/information", {
                     templateUrl: "/assets/html/information.html"
                 });

    $routeProvider.when("/file", {
        templateUrl: "/assets/html/templates/show-file.html"
    });

});