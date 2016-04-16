package com.devmikroblog.services.implementations.behaviour

/**
 * Created by dominik on 16.04.16.
 */
import com.devmikroblog.services.implementations.PostService
import com.devmikroblog.utils.PostServiceMocks
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

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

    }

    @Test
    fun testUpdate() {

    }
}