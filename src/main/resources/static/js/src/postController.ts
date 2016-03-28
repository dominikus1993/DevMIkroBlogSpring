///<reference path="tsd.d.ts"/>
///<reference path="postService.ts"/>

module DevMikroblog.Controllers{
    import IScope = angular.IScope;
    import IPostService = DevMikroblog.Services.IPostService;
    export class PostController{
        constructor(private rootSocpe:ng.IRootElementService, private scope:ng.IScope, private postService:IPostService){

        }
    }
}