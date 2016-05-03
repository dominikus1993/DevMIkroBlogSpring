///<reference path="tsd.d.ts"/>
///<reference path="postService.ts"/>

module Controllers{
    import IPostService = Services.IPostService;
    export class PostController{
        constructor(private rootSocpe:ng.IRootElementService, private scope:ng.IScope, private postService:IPostService){

        }
    }
}