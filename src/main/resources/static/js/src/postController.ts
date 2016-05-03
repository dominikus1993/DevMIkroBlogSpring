///<reference path="tsd.d.ts"/>
///<reference path="postService.ts"/>

module Controllers{
    import IPostService = Services.IPostService;
    export class PostController{

        public posts: Model.Post[];

        constructor(private rootSocpe:ng.IRootElementService, private scope:ng.IScope, private postService:IPostService){

        }

        public getAll(){
            this.postService.getAll((data: Model.Result<Model.Post[]>) => {
                if(data.success){
                    this.posts = data.value.reverse();
                }
            });
        }
    }
}