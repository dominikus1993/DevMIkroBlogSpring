///<reference path="tsd.d.ts"/>

module DevMikroblog.Controllers{
    export class HomeController{

        constructor(private rootScope:ng.IRootScopeService, private scope:ng.IScope){
            
        }

        public greeting = {id:"xxx", content:"Hello World"};
    }
}