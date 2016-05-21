///<reference path="tsd.d.ts"/>

module Controllers{
    export class HomeController{

        constructor(private scope:ng.IScope){

        }

        public greeting = {id:"xxx", content:"Hello World"};
    }
}