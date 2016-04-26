package com.devmikroblog.repositories.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.repositories.BaseRepository
import com.devmikroblog.repositories.interfaces.ICommentsRepository
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import java.util.function.Predicate

/**
 * Created by dominik on 26.04.16.
 */
class CommentsRepository : BaseRepository ,ICommentsRepository {

    @Autowired
    constructor(sessionFactory: SessionFactory) : super(sessionFactory){

    }

    override fun read(postId: Int): List<Post>? {
        throw UnsupportedOperationException()
    }

    override fun create(comment: Post?, parent: Post?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun update(comments: Post?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun delete(comment: Post?): Boolean {
        throw UnsupportedOperationException()
    }
}