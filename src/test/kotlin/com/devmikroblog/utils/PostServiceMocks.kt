package com.devmikroblog.utils

import com.devmikroblog.model.Post
import com.devmikroblog.model.Role
import com.devmikroblog.model.User
import com.devmikroblog.repositories.interfaces.IPostRepository
import org.mockito.Mockito.*;
import java.util.function.Predicate

/**
 * Created by dominik on 22.03.16.
 */
object PostServiceMocks {
    private val predicateById = Predicate<Post> { x -> x.id == 1 }
    private val predicateByAuthorLogin = Predicate<Post> { x -> x.author.login == "dominikus1993" }

    fun getIdPredicate(): java.util.function.Predicate<Post> {
        return predicateById
    }

    fun getIPostRepositoryMock(): IPostRepository{
        val mockRes = mock(IPostRepository::class.java);
        `when`(mockRes.read()).thenReturn(arrayListOf(Post(1, "Test", 0, User(), listOf(), listOf())))
        `when`(mockRes.read(predicateById)).thenReturn(Post(1,"Test", 0, User(), listOf(), listOf()))
        `when`(mockRes.read(predicateByAuthorLogin)).thenReturn(Post(1,"Test", 0, User(), listOf(), listOf()))
        return mockRes;
    }
}