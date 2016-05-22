///<reference path="tsd.d.ts"/>

module Services{
    import User = Model.User;
    export interface IUserService{
        login():void;
        register():void;
        getLoggedUser(callback: (result: Model.HttpData<User>) => void):void;
        getAllUsers(callback: (result: Model.HttpData<User[]>) => void):void;
    }

    export class UserService implements IUserService{

        constructor(private $http: ng.IHttpService) {

        }

        login():void{

        }

        register():void{

        }

        getLoggedUser(callback: (result: Model.HttpData<User>) => void):void{
            this.$http.get(Urls.getLoggedUser).then( (res : Model.HttpData<User>) => {
                callback(res);
            }).catch(error => {
               console.error(error);
            });
        }

        getAllUsers(callback: (result: Model.HttpData<User[]>) => void):void{
            this.$http.get(Urls.getAllUsers).then( (res : Model.HttpData<User[]>) => {
                callback(res);
            }).catch(error => {
                console.error(error);
            })
        }
    }
}