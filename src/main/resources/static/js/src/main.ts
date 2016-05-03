///<reference path="tsd.d.ts"/>
///<reference path="homeController.ts"/>

const appModule = angular.module("devmikroblog", []);
appModule.controller("HomeController", ["$rootScope", "$scope", ($rootScope, $scope) => new Controllers.HomeController($rootScope, $scope)]);
appModule.controller("UserController", ["$rootScope", "$scope"]);