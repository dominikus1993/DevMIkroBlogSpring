package com.devmikroblog.services.interfaces

import com.devmikroblog.model.Post
import com.devmikroblog.model.Result
import org.hibernate.sql.Update
import org.springframework.stereotype.Service

/**
 * Created by dominik on 22.03.16.
 */
interface IPostService {
    fun getAll(): Result<List<Post>?>
    fun getBy(predicate: (Post) -> Boolean):Result<Post?>
    fun create(post: Post):Result<Post?>
    fun update(post: Post, userId: Int): Boolean
}