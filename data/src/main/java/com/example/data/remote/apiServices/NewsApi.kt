package com.example.data.remote.apiServices

import com.example.data.remote.dtos.NewsDto
import com.example.data.utils.Constants.Companion.PAGING_LIMIT
import com.example.data.utils.Constants.Companion.NEWS_API_KEY
import com.example.data.utils.Constants.Companion.NEWS_LANGUAGE
import com.example.data.utils.Constants.Companion.NEWS_QUERY
import com.example.data.utils.base.paging.BaseNews
import com.example.data.utils.base.paging.BasePagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/everything")
    suspend fun getNews(
        @Query("q") q: String = NEWS_QUERY,
        @Query("pageSize") pageSize: String = "1",
        @Query("language") language: String = NEWS_LANGUAGE,
        @Query("apiKey") apiKey: String = NEWS_API_KEY,
        @Query("page") page: Int,
        ): Response<BaseNews<NewsDto>>
}