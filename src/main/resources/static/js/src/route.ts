///<reference path="tsd.d.ts"/>


module Routing{
    export function get(locationProvider: angular.ILocationProvider, routeProvider: angular.route.IRouteProvider){
        routeProvider.when("/", { templateUrl: "/all.html", controller: "PostController", controllerAs: "pc" });
        routeProvider.when("/Post/:postId?", { templateUrl: `/post.html`, controller: "PostByIdController", controllerAs: "pc" });
        routeProvider.otherwise({redirectTo: "/"});
        locationProvider.html5Mode(false).hashPrefix("!");
    }
}