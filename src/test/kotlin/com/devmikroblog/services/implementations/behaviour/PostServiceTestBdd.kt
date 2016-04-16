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
public class PostServiceTestBdd{
    private val postService: IPostService = PostService(PostServiceMocks.getIPostRepositoryMock());

    @Test
    fun testGetAll() {

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