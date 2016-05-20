package com.devmikroblog.repositories.interfaces

import com.devmikroblog.model.Post

/**
 * Created by dominik on 22.03.16.
 */
interface IPostRepository :IRepository<Post>{
    fun getPostById(id:Int):Post?;
}