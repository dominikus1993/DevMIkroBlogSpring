///<reference path="tsd.d.ts"/>

module Urls{
    export const getAllPosts = "/api/post/getAll";
    export const createPost = "/api/post/create";
    export const deletePost = (postId:number) => `/api/post/delete/${postId}`;
    export const getLoggedUser = "/api/auth/getLoggedUser";
    export const getPostById = (id:number) => `/api/post/get/${id}`;
}