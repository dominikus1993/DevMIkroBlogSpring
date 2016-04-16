package com.devmikroblog.services.implementations.behaviour

/**
 * Created by dominik on 16.04.16.
 */
import com.devmikroblog.model.Post
import com.devmikroblog.services.implementations.PostService
import com.devmikroblog.utils.PostServiceMocks
import info.solidsoft.mockito.java8.LambdaMatcher
import org.junit.Test
import org.mockito.Mockito.*
import java.util.function.Predicate

public class PostServiceTestBdd{

    @Test
    fun testGetAll() {
        val mockedPostRepository = PostServiceMocks.getIPostRepositoryMock()
        val postService = PostService(mockedPostRepository);
        val testResult = postService.getAll()
        verify(mockedPostRepository, times(1)).read()
    }

    @Test
    fun testGetById() {
        val mockedPostRepository = PostServiceMocks.getIPostRepositoryMock()
        val postService = PostService(mockedPostRepository);
        val testResult = postService.getBy(PostServiceMocks.predicateById)
        verify(mockedPostRepository, times(1)).read(PostServiceMocks.predicateById)
    }

    @Test
    fun testGetByAuthorLogin() {
        val mockedPostRepository = PostServiceMocks.getIPostRepositoryMock()
        val postService = PostService(mockedPostRepository);
        val testResult = postService.getBy(PostServiceMocks.predicateByAuthorLogin)
        verify(mockedPostRepository, times(1)).read(PostServiceMocks.predicateByAuthorLogin)
    }

    @Test
    fun testCreate() {
        val mockedPostRepository = PostServiceMocks.getIPostRepositoryMock()
        val postService = PostService(mockedPostRepository);
        val testResult = postService.create(Post())
        verify(mockedPostRepository, times(1)).create(any(Post::class.java))
    }

    @Test
    fun testUpdate() {
        val testPost = Post()
        testPost.id = 1
        val mockedPostRepository = PostServiceMocks.getIPostRepositoryMock()
        val postService = PostService(mockedPostRepository);
        val testResult = postService.update(PostServiceMocks.testPost, 1)
        verify(mockedPostRepository, times(1)).update(any(Post::class.java))
        //verify(mockedPostRepository, times(1)).read(argThat(LambdaMatcher(Predicate<Post>({ x -> x.id == 1 })))
    }
}