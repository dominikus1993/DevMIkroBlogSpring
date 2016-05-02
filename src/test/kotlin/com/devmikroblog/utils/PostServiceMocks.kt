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
    public val predicateById = Predicate<Post> { x -> x.id == 1 }
    public val predicateByAuthorLogin = Predicate<Post> { x -> x.author?.login == "dominikus1993" }
    public val testPost = Post(1, "Test", 1, User(), listOf(), listOf())

    fun getIPostRepositoryMock(): IPostRepository{
        val mockRes = mock(IPostRepository::class.java);
        `when`(mockRes.read()).thenReturn(arrayListOf(Post(1, "Test", 0, User(1, "a", "a", listOf(), Role.ADMIN, arrayListOf()), listOf(), listOf())))
        `when`(mockRes.read(predicateById)).thenReturn(Post(1,"Test", 0, User(), listOf(), listOf()))
        `when`(mockRes.read(predicateByAuthorLogin)).thenReturn(Post(1,"Test", 0, User(), listOf(), listOf()))
        `when`(mockRes.create(any(Post::class.java))).thenReturn(true)
        `when`(mockRes.update(any(Post::class.java))).thenReturn(false)
        `when`(mockRes.update(testPost)).thenReturn(true)
        return mockRes;
    }
}