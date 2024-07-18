package com.pahadi.mybasearch.api

import com.pahadi.mybasearch.model.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("top-headlines")
    suspend fun getTopHeadLines(@Query("country") country: String, @Query("page") page: Int =1, @Query("pageSize") pageSize: Int =20) : TopHeadlinesResponse

}