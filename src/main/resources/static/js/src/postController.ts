///<reference path="tsd.d.ts"/>
///<reference path="postService.ts"/>
///<reference path="userService.ts"/>

module Controllers{
    import IPostService = Services.IPostService;
    export class PostController{

        public posts: Model.Post[];
        public post : Model.Post;
        public postToCreation: Model.PostToCreation;
        public postToUpdate:Model.PostToUpdate;
        public toUpdate = false;
        public loggedUser:Model.User;


        constructor(private scope:ng.IScope, private postService:IPostService, private userService : Services.IUserService, postMode : Model.PostMode, postId ?: number){
            this.getLoggedUser();
            this.resolvePostMode(postMode, postId)
        }

        public resolvePostMode(postMode: Model.PostMode, postId ?: number){
            switch (postMode){
                case Model.PostMode.AllPost:
                    this.getAll();
                    break;
                case Model.PostMode.PostById:
                    this.getById(postId);
                    break;
            }
        }

        public getById(postId){
            this.postService.getById(postId, (res:Model.HttpData<Model.Post>) => {
                if(res.status == 200 && res.data.success){
                    this.post = res.data.value;
                }
            })
        }

        public isEdited() {
            this.postToUpdate = new Model.PostToUpdate(this.post.id,  this.post.message);
            this.toUpdate = !this.toUpdate;
            console.log(this.toUpdate)
        }

        public getLoggedUser(){
            this.userService.getLoggedUser((res) => {
                if(res.status == 200 && res.data.success) {
                    this.loggedUser = res.data.value;
                }
            });
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

        public isOwner(userId : number){
            if(this.loggedUser){
                return userId == this.loggedUser.id || this.loggedUser.role == "ADMIN";
            }
            return false;
        }

        public edit(){
            this.postService.update(this.postToUpdate, (result: Model.HttpData<boolean>) => {
                if (result.status == 200 && result.data.success && result.data.value) {
                    this.post.message = this.postToUpdate.message;
                }
            });

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