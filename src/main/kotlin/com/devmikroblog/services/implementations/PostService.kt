package com.devmikroblog.services.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.model.Result
import com.devmikroblog.repositories.interfaces.IPostRepository
import com.devmikroblog.services.interfaces.IPostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Function
import java.util.function.Predicate

/**
 * Created by dominik on 22.03.16.
 */
@Service
class PostService : IPostService {
    private val postRepository:IPostRepository;

    @Autowired
    constructor(postRepository: IPostRepository) {
        this.postRepository = postRepository
    }

    override fun getPostsBy(predicate: Predicate<Post>): Result<List<Post>?> {
        throw UnsupportedOperationException()
    }

    override fun getAll(): Result<List<Post>?> {
        return Result.ErrorWhenNoData(postRepository.read())
    }

    override fun getBy(predicate: Predicate<Post>): Result<Post?> {
        return Result.ErrorWhenNoData(postRepository.read(predicate))
    }

    override fun create(post: Post): Result<Boolean> {
        val queryResult = postRepository.create(post)
        return Result.ErrorWhenNoData(queryResult, listOf("Bad data"))
    }

    override fun update(post: Post, userId: Int): Result<Boolean> {
        return action(post, userId, Function { x -> postRepository.update(x) })
    }

    override fun delete(post: Post, userId: Int): Result<Boolean> {
        return action(post, userId, Function { x -> postRepository.delete(x) })
    }

    private fun action(post: Post, userId: Int, function: Function<Post, Boolean>): Result<Boolean> {
        val postsInDb = getAll()

        val existPost = Result.ErrorWhenNoData(postsInDb.value?.filter { x -> x.id == post.id && x.author.id == userId }?.singleOrNull())

        if(existPost.isSuccess){
            val queryResult = function.apply(post)
            return Result(queryResult, listOf("Update error"))
        }
        return Result(false)
    }
}