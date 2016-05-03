///<reference path="tsd.d.ts"/>
///<reference path="model.ts"/>
///<reference path="urls.ts"/>

module Services{
    import Result = Model.Result;
    export interface IPostService{
        getAll(callback: (data:Model.Result<Model.Post>) => void);
    }

    export class PostService implements IPostService{

        private http: ng.IHttpService;

        constructor($http: ng.IHttpService) {
            this.http = $http;
        }

        getAll(callback: (data:Model.Result<Model.Post>) => void){
            return this.http.get(Urls.getAllPosts).then((res:Model.Result<Model.Post>) => {
                if(res.isSuccess){

                }
            });
        }
    }
}