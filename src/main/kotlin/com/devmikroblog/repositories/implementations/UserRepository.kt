package com.devmikroblog.repositories.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.model.Role
import com.devmikroblog.model.User
import com.devmikroblog.repositories.BaseRepository
import com.devmikroblog.repositories.interfaces.IUserRepository
import org.hibernate.SessionFactory
import org.hibernate.criterion.Restrictions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.function.Predicate
import javax.transaction.Transactional

/**
 * Created by dominik on 12.04.16.
 */
@Repository
@Transactional
open class UserRepository : BaseRepository, IUserRepository {

    @Autowired
    constructor(sessionFactory: SessionFactory) : super(sessionFactory) {

    }

    override fun login(username: String, password: String): User? {
        val user = read()?.find { x -> x.login.equals(username) && x.password.equals(password) }
        return user as? User ?: null
    }

    override fun register(user: User): Boolean {
        try {
            if (read()?.find { x -> x.login.equals(user.login) } == null) {
                getCurrentSession().save(user);
                return true
            } else {
                return false;
            }
        } catch(ex: Exception) {
            return false
        }
    }

    override fun getUserByUsername(username: String): User? {
        val session = getCurrentSession()
        val user = session.createCriteria(User::class.java).add(Restrictions.eq("login", username)).uniqueResult() as User?
        return user

    }

    override fun isAdmin(userId: Int): Boolean {
        val session = getCurrentSession()
        try {
            val user = session.get(User::class.java, userId) as User
            return user.role.equals(Role.ADMIN)
        } catch(ex: Exception) {
            return false
        }
    }

    override fun changeRole(userId: Int, role: Role): Boolean {
        throw UnsupportedOperationException()
    }

    override fun read(predicate: Predicate<User>): User? {
        val users = read()
        return users?.find { it -> predicate.test(it) }
    }

    @Suppress("UNCHECKED_CAST")
    override fun read(): List<User>? {
        val session = getCurrentSession()
        return session.createCriteria(Post::class.java).list() as List<User>
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

    override fun isOwner(postId: Int, userId: Int): Boolean {
        val session = getCurrentSession()
        try {
            val post = session.get(Post::class.java, postId) as Post
            return post.author.id == userId
        } catch(ex: Exception) {
            return false
        }
    }

}