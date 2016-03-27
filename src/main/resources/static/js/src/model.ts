
module DevMikroblog.Models{
    export class Result<T>{
        value:T;
        isSuccess:boolean;
    }

    export class UserForLogin{
        public userName:string = "";
        public password:string = "";
        public isRemember:boolean = true;
    }
}