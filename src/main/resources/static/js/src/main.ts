///<reference path="tsd.d.ts"/>
///<reference path="homeController.ts"/>
///<reference path="postController.ts"/>
///<reference path="postService.ts"/>


const appModule = angular.module("devmikroblog", []);
appModule.controller("HomeController", ["$rootScope", "$scope", ($rootScope, $scope) => new Controllers.HomeController($rootScope, $scope)]);
appModule.controller("PostController", ["$rootScope", "$scope", "PostService", ($rootScope, $scope, postService) => new Controllers.PostController($rootScope, $scope, postService)]);
appModule.controller("UserController", ["$rootScope", "$scope"]);

appModule.factory("PostService", ($http) => new Services.PostService($http));