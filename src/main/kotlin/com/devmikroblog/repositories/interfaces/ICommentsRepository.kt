package com.devmikroblog.repositories.interfaces

import com.devmikroblog.model.Post
import java.util.function.Predicate

/**
 * Created by dominik on 25.04.16.
 */
interface ICommentsRepository {
    fun read():List<Post>?;
    fun read(predicate: Predicate<Post>):Post?;
    fun create(comment: Post?, parent:Post?):Boolean;
    fun update(comments: Post?):Boolean;
    fun delete(comment: Post?):Boolean;
}