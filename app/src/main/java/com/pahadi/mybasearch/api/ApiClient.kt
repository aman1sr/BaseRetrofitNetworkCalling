package com.pahadi.mybasearch.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{
    private const val BASE_URL = "https://newsapi.org/v2/"

    val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(HttpClient.okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val networkService: NetworkService by lazy {
        RetrofitClient.retrofit.create(NetworkService::class.java)
    }
}