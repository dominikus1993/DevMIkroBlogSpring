///<reference path="tsd.d.ts"/>
///<reference path="model.ts"/>

module Services{
    export interface IPostService{
        getAll(callback: (data:Model.Result<Model.Post>) => void);
    }

    export class PostService implements IPostService{
        getAll(callback: (data:Model.Result<Model.Post>) => void){

        }
    }
}