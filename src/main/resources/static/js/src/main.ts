///<reference path="tsd.d.ts"/>
///<reference path="homeController.ts"/>
///<reference path="postController.ts"/>
///<reference path="postService.ts"/>
///<reference path="userController.ts"/>
///<reference path="userService.ts"/>

const appModule = angular.module("devmikroblog", ['ngCookies']);

appModule.controller("HomeController", ["$rootScope", "$scope", ($rootScope, $scope) => new Controllers.HomeController($rootScope, $scope)]);
appModule.controller("PostController", ["$rootScope", "$scope", "PostService", ($rootScope, $scope, postService) => new Controllers.PostController($rootScope, $scope, postService)]);
appModule.controller("UserController", ["$rootScope", "$scope", "UserService", ($rootScope, $scope, userService) => new Controllers.UserController($rootScope, $scope, userService)]);

appModule.factory("PostService", ($http) => new Services.PostService($http));
appModule.factory("UserService", ($http) => new Services.UserService($http));