package com.devmikroblog.repositories

import com.devmikroblog.repositories.interfaces.IPostRepository
import com.devmikroblog.repositories.interfaces.IRepository
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by dominik on 22.03.16.
 */
open abstract class BaseRepository<TEntity>: IRepository<TEntity>{
    private val sessionFactory:SessionFactory;

    @Autowired
    constructor(sessionFactory:SessionFactory) {
        this.sessionFactory = sessionFactory
    }
    protected fun getCurrentSession(): Session {
        sessionFactory.currentSession.clear()
        return sessionFactory.currentSession
    }
}