package com.devmikroblog.services.implementations.expectedResult

import com.devmikroblog.repositories.interfaces.IPostRepository
import com.devmikroblog.services.implementations.PostService
import com.devmikroblog.services.interfaces.IPostService
import com.devmikroblog.utils.Mocks
import org.junit.Test
import org.hamcrest.CoreMatchers.`is`;
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.*
import org.junit.*
import org.junit.Before
import java.util.function.Predicate

/**
 * Created by dominik on 22.03.16.
 */
class PostServiceTest {

    private val postService: IPostService = PostService(Mocks.getIPostRepositoryMock());

    @Test
    fun testGetAll() {
        val testResult = postService.getAll();
        assertTrue(testResult.isSuccess)
        assertThat(testResult.value, `is`(not(emptyList())))

    }

    @Test
    fun testGetById() {
        val testResult = postService.getBy (Predicate { x -> x.id == 1 })
        assertTrue(testResult.isSuccess)
        assertNotNull(testResult.value)
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