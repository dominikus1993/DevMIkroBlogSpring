package com.devmikroblog.services.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.model.Result
import com.devmikroblog.model.Role
import com.devmikroblog.model.User
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

    override fun getById(id: Int): Result<Post?> {
        return Result.ErrorWhenNoData(postRepository.getPostById(id))
    }

    override fun getPostsBy(predicate: Predicate<Post>): Result<List<Post>?> {
        val queryResult = postRepository.read()
        val filterResult = queryResult?.filter { x -> predicate.test(x) }
        return Result.ErrorWhenNoData(filterResult, listOf("No data"))
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

    override fun update(post: Post, user: User): Result<Boolean> {
        val postFromDb = getById(post.id)
        if(postFromDb.isSuccess && isOwnerOrAdmin(postFromDb.value as Post, user)){
            post.author = postFromDb.value.author;
            post.rate = postFromDb.value.rate;
            post.comments = postFromDb.value.comments;
            post.tags = postFromDb.value.tags;
            post.votes = postFromDb.value.votes;
            return Result(postRepository.update(post))
        }
        return Result(false)
    }

    override fun delete(postId: Int, user: User): Result<Boolean> {
        val post = getById(postId)
        if(post.isSuccess && isOwnerOrAdmin(post.value as Post, user)){
            return Result(postRepository.delete(post.value))
        }
        return Result(false)
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

    private fun isOwnerOrAdmin(post: Post, user: User):Boolean{
        return (post.author.id == user.id || user.role == Role.ADMIN)
    }
}