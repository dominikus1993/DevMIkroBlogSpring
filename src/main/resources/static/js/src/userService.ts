///<reference path="tsd.d.ts"/>

module Services{
    export interface IUserService{
        login():void;
        register():void;
    }

    export class UserService implements IUserService{

        private http: ng.IHttpService;

        constructor($http: ng.IHttpService) {
            this.http = $http;
        }

        login():void{

        }

        register():void{

        }
    }
}