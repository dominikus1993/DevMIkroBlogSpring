///<reference path="tsd.d.ts"/>
///<reference path="model.ts"/>

module DevMikroblog.Services{
    import Result = DevMikroblog.Models.Result;
    import Post = DevMikroblog.Models.Post;

    export interface IPostService{
        getAll(callback: (data:Result<Post>) => void);
    }

    export class PostService implements IPostService{
        getAll(callback: (data:Result<Post>) => void){

        }
    }
}