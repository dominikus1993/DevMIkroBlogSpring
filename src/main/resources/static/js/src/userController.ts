///<reference path="tsd.d.ts"/>
///<reference path="userService.ts"/>

module Controllers{
    export class UserController{
        constructor(private scope:ng.IScope, private userService:Services.IUserService){

        }
    }
}