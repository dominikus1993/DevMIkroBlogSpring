///<reference path="tsd.d.ts"/>
///<reference path="postService.ts"/>

module Controllers{
    import IPostService = Services.IPostService;
    export class PostController{

        public posts: Model.Post[];

        constructor(private rootSocpe:ng.IRootElementService, private scope:ng.IScope, private postService:IPostService){
            this.getAll();
        }

        public getAll(){
            this.postService.getAll((result: Model.HttpData<Model.Post[]>) => {
                console.log(":dfsaadsf");
                console.log(result);
                if(result.status == 200 && result.data.success){
                    this.posts = result.data.value.reverse();
                }
            });
        }
    }
}