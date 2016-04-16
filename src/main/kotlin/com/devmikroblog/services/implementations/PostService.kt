package com.devmikroblog.services.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.model.Result
import com.devmikroblog.repositories.interfaces.IPostRepository
import com.devmikroblog.services.interfaces.IPostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
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
        val postInDb = getBy(Predicate { x -> x.id == 1 && x.author.id == userId })

        if(postInDb.isSuccess){
            val queryResult = postRepository.update(post)
            return Result(queryResult, listOf("Update error"))
        }
        return Result(false)
    }

    override fun delete(post: Post, userId: Int): Result<Boolean> {
        throw UnsupportedOperationException()
    }
}