package com.pahadi.mybasearch

import com.pahadi.mybasearch.api.ApiClient
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host)
 *
 * See [testing documentation](http://d.android.com/tools/testing)
 * ++
 * src(https://www.tutorialspoint.com/junit/junit_using_assertion.htm)
 *
 */

@ExperimentalCoroutinesApi
class NewsUnitTest {
    @Test
    fun `GET newsTopHeadLine`() {
        runBlocking {
            val response = ApiClient.networkService.getTopHeadLines("us")
            assertNotNull(response.articles)
        }
    }
    @Test
    fun `GET newsTopHeadLine check status`() {
        runBlocking {
            val response = ApiClient.networkService.getTopHeadLines("us")
            assertEquals("ok", response.status)
        }
    }

    @Test
    fun `GET newsTopHeadLine check totalResults`() {
        runBlocking {
            val response = ApiClient.networkService.getTopHeadLines("us")
            assertTrue(response.count >= 0)
        }
    }

    @Test
    fun `GET newsTopHeadLine check article fields`() {
        runBlocking {
            val response = ApiClient.networkService.getTopHeadLines("us")
            response.articles.forEach { article ->
                assertNotNull(article.title)
                assertNotNull(article.url)
                assertNotNull(article.source)
            }
        }
    }

    @Test
    fun `GET newsTopHeadLine with pagination`() {
        runBlocking {
            val responsePage1 = ApiClient.networkService.getTopHeadLines("us", page = 1)
            val responsePage2 = ApiClient.networkService.getTopHeadLines("us", page = 2)
            assertNotEquals(responsePage1.articles, responsePage2.articles)
        }
    }

    @Test
    fun `GET newsTopHeadLine with empty response`() {
        runBlocking {
            val response = ApiClient.networkService.getTopHeadLines("xx")
            assertTrue(response.articles.isEmpty())
        }
    }






}