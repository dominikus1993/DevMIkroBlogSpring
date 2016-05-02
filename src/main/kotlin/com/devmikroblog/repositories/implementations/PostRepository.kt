package com.devmikroblog.repositories.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.model.Role
import com.devmikroblog.model.Tag
import com.devmikroblog.model.User
import com.devmikroblog.repositories.BaseRepository
import com.devmikroblog.repositories.interfaces.IPostRepository
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.function.Predicate

/**
 * Created by dominik on 22.03.16.
 */
@Repository
open class PostRepository : BaseRepository, IPostRepository {

    @Autowired
    constructor(sessionFactory: SessionFactory) : super(sessionFactory){

    }

    override fun read(): List<Post>? {
        return (getCurrentSession().createCriteria(Post::class.java).list() as List<Post>)
    }

    override fun read(predicate: Predicate<Post>): Post? {
        val posts = read()
        return posts?.find { it -> predicate.test(it) }
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
        val session = getCurrentSession()
        try{
            session.beginTransaction();
            session.update(post);
            session.transaction.commit();
            session.close();
            return true
        }catch(ex:Exception){
            session.transaction.rollback()
            return false
        }finally{
            session.close()
        }


    }

    override fun delete(post: Post?): Boolean {
        val session = getCurrentSession()
        try{
            val postToDelete = session.get(Post::class.java, post?.id)
            session.delete(postToDelete)
            return true
        } catch(ex:Exception){
            return false
        }finally{
            session.close()
        }
    }

}