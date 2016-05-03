///<reference path="tsd.d.ts"/>
///<reference path="userService.ts"/>

module Controllers{
    export class UserController{
        constructor(private rootScope:ng.IRootScopeService, private scope:ng.IScope, private userService:Services.IUserService){

        }
    }
}