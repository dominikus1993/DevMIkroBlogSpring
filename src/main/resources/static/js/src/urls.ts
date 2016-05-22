///<reference path="tsd.d.ts"/>

module Urls{
    export const getAllPosts = "/api/post/getAll";
    export const createPost = "/api/post/create";
    export const deletePost = (postId:number) => `/api/post/delete/${postId}`;
    export const getLoggedUser = "/api/auth/getLoggedUser";
    export const getAllUsers = "/api/auth/getAllUsers";
    export const deleteUser = (userId:number) => `/api/auth/deleteUser/${userId}`;
    export const getPostById = (id:number) => `/api/post/get/${id}`;
    export const updatePost = "api/post/update";
    export const SessionCookie = "SESSION";
}