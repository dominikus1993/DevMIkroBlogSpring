package com.devmikroblog.utils

import com.devmikroblog.model.Post
import com.devmikroblog.repositories.interfaces.IPostRepository
import org.mockito.Mockito.*;
import javax.sql.rowset.Predicate

/**
 * Created by dominik on 22.03.16.
 */
object Mocks {
    fun getIPostRepositoryMock(): IPostRepository{
        val mockRes = mock(IPostRepository::class.java);
        `when`(mockRes.read()).thenReturn(arrayListOf(Post(1, "Test", 0)));
        `when`(mockRes.read{it -> it.id == 1}).thenReturn(Post(1,"Test", 0))
        return mockRes;
    }
}