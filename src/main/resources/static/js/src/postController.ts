///<reference path="tsd.d.ts"/>
///<reference path="postService.ts"/>

module Controllers{
    import IPostService = Services.IPostService;
    export class PostController{

        public posts: Model.Post[];
        public postToCreation: Model.PostToCreation;

        constructor(private rootSocpe:ng.IRootElementService, private scope:ng.IScope, private postService:IPostService){
            this.getAll();
        }

        public getAll(){
            this.postService.getAll((result: Model.HttpData<Model.Post[]>) => {
                console.log(result);
                if(result.status == 200 && result.data.success){
                    this.posts = result.data.value.reverse();
                }
            });
        }

        public create(){
            if(this.postToCreation){
                this.postService.create(this.postToCreation, (data : Model.HttpData<Model.Post>) => {
                    if(data.status == 200 && data.data.success){
                        this.posts = [data.data.value].concat(this.posts);
                    }
                });
            }
        }

        public deletePost(postId : number){
            this.postService.deletePost(postId, result => {
                if (result.status === 200 && result.data.success) {
                    this.posts = _.without<Model.Post>(this.posts, this.posts.filter(x => x.id === postId)[0]);
                }
            });
        }
    }
}