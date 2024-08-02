package com.pahadi.mybasearch

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pahadi.mybasearch.api.ApiClient
import com.pahadi.mybasearch.model.TopHeadlinesResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    val networkService = ApiClient.networkService

    val _data = MutableStateFlow<TopHeadlinesResponse?>(null)
            val data : StateFlow<TopHeadlinesResponse?> = _data

    init {
        fetchNewsData()
    }

    private fun fetchNewsData() {
        Log.d("NewsHeadLine_d", "ask Network call")
        viewModelScope.launch {
            val response = networkService.getTopHeadLines("us")
            response?.let {
                Log.d("NewsHeadLine_d", "fetchNewsData: ${it.articles}")
            }
        }
    }
}