package com.devmikroblog.repositories.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.model.User
import com.devmikroblog.repositories.interfaces.IUserRepository
import org.springframework.stereotype.Repository

/**
 * Created by dominik on 12.04.16.
 */
@Repository
open class UserRepository : IUserRepository{
    override fun read(): List<User>? {
        throw UnsupportedOperationException()
    }

    override fun read(predicate: (User) -> Boolean): Post? {
        throw UnsupportedOperationException()
    }

    override fun create(post: User?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun update(post: User?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun delete(post: User?): Boolean {
        throw UnsupportedOperationException()
    }

}