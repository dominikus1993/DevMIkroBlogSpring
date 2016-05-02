package com.devmikroblog.repositories.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.repositories.BaseRepository
import com.devmikroblog.repositories.interfaces.ICommentsRepository
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by dominik on 26.04.16.
 */
class CommentsRepository : BaseRepository ,ICommentsRepository {

    @Autowired
    constructor(sessionFactory: SessionFactory) : super(sessionFactory){

    }

    @Suppress("UNCHECKED_CAST")
    override fun read(postId: Int): List<Post>? {
       val session = getCurrentSession()
        try{
            val hql = "SELECT p.*" +
                    "FROM posts p" +
                    "inner join posts_comments on (p.id = posts_comments.comments_id)"+
                    "where post_id = :id"
            val query = session.createQuery(hql)
            query.setInteger("id", postId)
            return (query.list() as? List<Post> ?: null)
        }catch(ex:Exception){
            return null
        }finally{
            session.close()
        }
    }

    override fun create(comment: Post?, parent: Post?): Boolean {
        val session = getCurrentSession()

        try{
            session.beginTransaction()
            val parentPost = (session.get(Post::class.java, parent?.id) as Post)
            parentPost.comments.toMutableList().add(comment as Post)
            session.saveOrUpdate(parentPost)
            session.transaction.commit()
            return true
        }catch(ex:Exception){
            session.transaction.rollback()
            return false
        }finally{
            session.close()
        }

    }

    override fun update(comment: Post?): Boolean {
        val session = getCurrentSession()
        try{
            session.beginTransaction();
            session.update(comment);
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

    override fun delete(comment: Post?): Boolean {
        val session = getCurrentSession()
        try{
            val commentToDelete = session.get(Post::class.java, comment?.id)
            session.delete(commentToDelete)
            return true
        } catch(ex:Exception){
            return false
        }finally{
            session.close()
        }
    }
}