
module Model{
    export type Role = "ADMIN" | "USER";
    
    export interface Result<T>{
        value:T;
        success:boolean;
    }

    export interface HttpData<T>{
        config:any;
        data: Result<T>;
        status:number;
        statusText:string;
    }

    export interface UserForLogin{
         userName:string;
         password:string;
         isRemember:boolean;
    }

    export interface User{
         id:number;
         login:string;
         activated:boolean;
         creationDate:Date;
         role: Role
    }

    export interface Post{
         id: number;
         message: string;
         rate: number;
         creationDate:Date;
         author:User;
         comments: Post[];
    }

    export interface PostToCreation{
         message:string;
    }

    export interface PostToUpdate{
        id:number;
        message:string;

    }

    export enum PostMode{
        AllPost,
        PostById
    }

    export enum UserMode{
        AllUsers,
        UserById,
        None
    }
}
