package com.devmikroblog.repositories.interfaces

import com.devmikroblog.model.Post
import java.util.function.Predicate

/**
 * Created by dominik on 25.04.16.
 */
interface ICommentsRepository {
    fun read(postId : Int):List<Post>?;
    fun create(comment: Post?, parent:Post?):Boolean;
    fun update(comment: Post?):Boolean;
    fun delete(comment: Post?):Boolean;
}