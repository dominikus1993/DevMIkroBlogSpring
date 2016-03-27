///<reference path="../typings/tsd.d.ts"/>
///<reference path="homeController.ts"/>

const appModule = angular.module("devmikroblog", []);
appModule.controller("HomeController", ["$rootScope", "$scope", ($rootScope, $scope) => new DevMikroblog.Controllers.HomeController($rootScope, $scope)]);
