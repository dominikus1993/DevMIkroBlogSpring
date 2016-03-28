package com.devmikroblog.repositories.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.model.Role
import com.devmikroblog.model.Tag
import com.devmikroblog.model.User
import com.devmikroblog.repositories.BaseRepository
import com.devmikroblog.repositories.interfaces.IPostRepository
import com.devmikroblog.sessionStrategy
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by dominik on 22.03.16.
 */
@Repository
open class PostRepository : BaseRepository<Post>, IPostRepository {

    @Autowired
    constructor(sessionFactory: SessionFactory) : super(sessionFactory){

    }

    override fun read(): List<Post>? {
        return arrayListOf(Post(1,"ahsdffgdas", 34343, User(), listOf(), listOf()), Post(2, "hello world", 0, User(), listOf(), listOf()))
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