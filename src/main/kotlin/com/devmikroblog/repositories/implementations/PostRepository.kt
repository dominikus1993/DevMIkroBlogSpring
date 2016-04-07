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
        return (getCurrentSession().createCriteria(Post::class.java).list() as List<Post>)
    }

    override fun read(predicate: (Post) -> Boolean): Post? {
        val posts = read()
        return posts?.find { it -> predicate(it) }
    }

    override fun create(post: Post?): Boolean {
        try{
            getCurrentSession().save(post);
            return true
        }catch(ex:Exception){
            return false
        }
    }

    override fun update(post: Post?): Boolean {
        try{
            val session = getCurrentSession()
            session.beginTransaction();
            session.update(post);
            session.transaction.commit();
            session.close();
            return true
        }catch(ex:Exception){
            return false
        }


    }

    override fun delete(post: Post?): Boolean {
        try{
            val session = getCurrentSession()
            val post = session.get(Post::class.java, post?.id)
            session.delete(post)
            return true
        } catch(ex:Exception){
            return false
        }
    }

}