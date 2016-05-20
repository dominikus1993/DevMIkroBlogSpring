///<reference path="tsd.d.ts"/>
///<reference path="model.ts"/>
///<reference path="urls.ts"/>

module Services{
    import Result = Model.Result;
    import Post = Model.Post;
    export interface IPostService{
        getAll(callback: (data:Model.HttpData<Model.Post[]>) => void);
        create(post : Model.PostToCreation, callback: (result : Model.HttpData<Model.Post>) => void)
    }

    export class PostService implements IPostService{

        private http: ng.IHttpService;

        constructor($http: ng.IHttpService) {
            this.http = $http;
        }

        getAll(callback: (data:Model.HttpData<Model.Post[]>) => void){
            return this.http.get(Urls.getAllPosts).then((res:Model.HttpData<Model.Post[]>) => {
                callback(res);
                return res;
            }).catch((error) => {
                console.error(error);
            });
        }

        create(post : Model.PostToCreation, callback: (result : Model.HttpData<Model.Post>) => void){
            return this.http({
                method : "POST",
                headers: {"Content-Type": "application/json"},
                url : Urls.createPost,
                data : JSON.stringify(post),

            }).then((res:Model.HttpData<Model.Post>) => {
                callback(res)
            }).catch((error) => {
                console.error(error);
            })
        }
    }
}