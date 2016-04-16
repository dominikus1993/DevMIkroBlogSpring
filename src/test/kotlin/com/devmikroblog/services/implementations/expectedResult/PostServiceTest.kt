package com.devmikroblog.services.implementations.expectedResult

import com.devmikroblog.model.Post
import com.devmikroblog.services.implementations.PostService
import com.devmikroblog.services.interfaces.IPostService
import com.devmikroblog.utils.PostServiceMocks
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by dominik on 22.03.16.
 */
class PostServiceTest {

    private val postService: IPostService = PostService(PostServiceMocks.getIPostRepositoryMock());

    @Test
    fun testGetAll() {
        val testResult = postService.getAll();
        assertTrue(testResult.isSuccess)
        assertThat(testResult.value, `is`(not(emptyList())))

    }

    @Test
    fun testGetById() {
        val testResult = postService.getBy (PostServiceMocks.predicateById)
        assertTrue(testResult.isSuccess)
        assertNotNull(testResult.value)
    }

    @Test
    fun testGetByAuthorLogin() {
        val testResult = postService.getBy (PostServiceMocks.predicateByAuthorLogin)
        assertTrue(testResult.isSuccess)
        assertNotNull(testResult.value)
    }

    @Test
    fun testCreate() {
        val testResult = postService.create(Post())
        assertTrue(testResult.isSuccess)
        assertTrue(testResult.value)
    }

    @Test
    fun testGetPostsByAuthor() {
        val testResult = postService.getPostsBy (PostServiceMocks.predicateByAuthorLogin)
        assertTrue(testResult.isSuccess)
        assertNotNull(testResult.value)
    }
}