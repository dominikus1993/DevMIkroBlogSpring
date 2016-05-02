package com.devmikroblog.services.interfaces

import com.devmikroblog.model.Post
import com.devmikroblog.model.Result
import java.util.function.Predicate

/**
 * Created by dominik on 02.05.16.
 */
public interface ICommentService{
    fun getByPost(postId:Int): Result<List<Post>?>
    fun create(comment: Post, parent:Post): Result<Boolean>
    fun update(comment: Post, userId: Int): Result<Boolean>
    fun delete(comment: Post, userId: Int): Result<Boolean>
}