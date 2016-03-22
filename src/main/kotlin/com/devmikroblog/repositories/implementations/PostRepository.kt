package com.devmikroblog.repositories.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.repositories.BaseRepository
import com.devmikroblog.repositories.interfaces.IPostRepository
import org.springframework.stereotype.Repository

/**
 * Created by dominik on 22.03.16.
 */
@Repository
open class PostRepository : BaseRepository<Post>(),IPostRepository {
    override fun read(): List<Post>? {
        return arrayListOf(Post(1,"ahsdffgdas", 34343), Post(2, "hello world", 0))
    }

    override fun read(predicate: (Post) -> Boolean): Post? {
        val posts = read()
        return posts?.find { it -> predicate(it) }
    }

    override fun create(post: Post?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun update(post: Post?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun delete(post: Post?): Boolean {
        throw UnsupportedOperationException()
    }

}