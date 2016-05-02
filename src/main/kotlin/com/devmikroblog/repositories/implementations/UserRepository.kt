package com.devmikroblog.repositories.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.model.Role
import com.devmikroblog.model.User
import com.devmikroblog.repositories.interfaces.IUserRepository
import org.springframework.stereotype.Repository
import java.util.function.Predicate

/**
 * Created by dominik on 12.04.16.
 */
@Repository
open class UserRepository : IUserRepository{
    override fun login(username: String, password: String): User {
        throw UnsupportedOperationException()
    }

    override fun register(user: User): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isAdmin(userId: Int): Boolean {
        throw UnsupportedOperationException()
    }

    override fun changeRole(userId: Int, role: Role): Boolean {
        throw UnsupportedOperationException()
    }

    override fun read(predicate: Predicate<User>): User? {
        throw UnsupportedOperationException()
    }

    override fun read(): List<User>? {
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