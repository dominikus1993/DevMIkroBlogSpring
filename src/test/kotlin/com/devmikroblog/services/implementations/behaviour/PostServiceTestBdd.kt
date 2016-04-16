package com.devmikroblog.services.implementations.behaviour

import com.devmikroblog.services.implementations.PostService
import com.devmikroblog.services.interfaces.IPostService
import com.devmikroblog.utils.PostServiceMocks
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test

/**
 * Created by dominik on 16.04.16.
 */
import org.mockito.Mockito.*;

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
    }

    @Test
    fun testGetByAuthorLogin() {
    }

    @Test
    fun testCreate() {

    }

    @Test
    fun testUpdate() {

    }
}