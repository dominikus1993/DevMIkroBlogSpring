
module Model{
    export class Result<T>{
        value:T;
        success:boolean;
    }

    export class HttpData<T>{
        public config:any;
        public data: Result<T>;
        public status:number;
        public statusText:string;
    }

    export class UserForLogin{
        public userName:string = "";
        public password:string = "";
        public isRemember:boolean = true;
    }

    export class User{
        public id:number = 0;
        public login:string = "";
        public role: "USER" | "ADMIN"
    }

    export class Post{
        public id: number = 0;
        public message: string = "";
        public rate: number = 0;
        public author:User;
        public comments: Post[];
    }

    export class PostToCreation{
        public message:string = ""
    }

    export class PostToUpdate{
        public id:number = 0;
        public message:string = "";
    }

    export enum PostMode{
        AllPost,
        PostById
    }
}
