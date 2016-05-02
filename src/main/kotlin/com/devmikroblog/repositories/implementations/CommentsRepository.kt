package com.devmikroblog.repositories.implementations

import com.devmikroblog.model.Post
import com.devmikroblog.repositories.BaseRepository
import com.devmikroblog.repositories.interfaces.ICommentsRepository
import org.hibernate.SessionFactory
import org.hibernate.Transaction
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
        val hql = "SELECT p.*" +
                  "FROM posts p" +
                  "inner join posts_comments on (p.id = posts_comments.comments_id)"+
                  "where post_id = :id"
        val query = getCurrentSession().createQuery(hql)
        query.setInteger("id", postId)
        return query.list() as List<Post>
    }

    override fun create(comment: Post?, parent: Post?): Boolean {
        val session = getCurrentSession()

        try{
            session.beginTransaction()
            val parentPost = (session.get(Post::class.java, parent?.id) as Post)
            val commentId = session.save(comment) as Int
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

    override fun update(comments: Post?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun delete(comment: Post?): Boolean {
        throw UnsupportedOperationException()
    }
}