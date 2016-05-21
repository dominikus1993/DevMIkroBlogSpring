///<reference path="tsd.d.ts"/>
///<reference path="homeController.ts"/>
///<reference path="postController.ts"/>
///<reference path="postService.ts"/>
///<reference path="userController.ts"/>
///<reference path="userService.ts"/>
///<reference path="route.ts"/>


const appModule = angular.module("devmikroblog", ['ngCookies', 'ngRoute']);

appModule.controller("HomeController", ["$rootScope", "$scope", ($rootScope, $scope) => new Controllers.HomeController($rootScope, $scope)]);
appModule.controller("PostController", ["$rootScope", "$scope", "PostService", "UserService", ($rootScope, $scope, postService, userService) => new Controllers.PostController($rootScope, $scope, postService, userService, Model.PostMode.AllPost)]);
appModule.controller("PostByIdController", ["$rootScope", "$scope", "PostService", "UserService", "$routeParams", ($rootScope, $scope, postService, userService, $routeParams) => new Controllers.PostController($rootScope, $scope, postService, userService, Model.PostMode.PostById, $routeParams.postId)]);
appModule.controller("UserController", ["$rootScope", "$scope", "UserService", ($rootScope, $scope, userService) => new Controllers.UserController($rootScope, $scope, userService)]);

appModule.factory("PostService", ($http) => new Services.PostService($http));
appModule.factory("UserService", ($http) => new Services.UserService($http));

appModule.config(["$routeProvider", "$locationProvider", ($routeProvider, $locationProvider) => Routing.get($locationProvider, $routeProvider)]);