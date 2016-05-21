///<reference path="tsd.d.ts"/>
///<reference path="homeController.ts"/>
///<reference path="postController.ts"/>
///<reference path="postService.ts"/>
///<reference path="userController.ts"/>
///<reference path="userService.ts"/>
///<reference path="route.ts"/>


const appModule = angular.module("devmikroblog", ["ngRoute"])
    .config(($routeProvider:angular.route.IRouteProvider) => {
        $routeProvider.when("/", {templateUrl: "/all.html"})
            .when("/Post/:postId", { templateUrl: "/post.html"})
            .otherwise({redirectTo: "/"});
    })
    .factory("PostService", ["$http", ($http) => new Services.PostService($http)])
    .factory("UserService", ["$http", ($http) => new Services.UserService($http)])
    .controller("PostController", ["$scope", "PostService", "UserService", ($scope, postService, userService) => new Controllers.PostController($scope, postService, userService, Model.PostMode.AllPost)])
    .controller("PostByIdController", ["$routeParams", "$scope", "PostService", "UserService", ($routeParams, $scope, postService, userService) => new Controllers.PostController($scope, postService, userService, Model.PostMode.PostById, $routeParams.postId)])
    .controller("UserController", ["$scope", "UserService", ($scope, userService) => new Controllers.UserController($scope, userService)]);



