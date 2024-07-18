package com.pahadi.mybasearch.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object HttpClient {
    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        HttpLoggingInterceptor.Level.NONE
    }



    val okHttpClient : OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(AuthTokenInterceptor())
            .addInterceptor(httpLoggingInterceptor)
            .build()
}