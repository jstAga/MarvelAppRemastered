package com.example.data.remote.pagingSources

import com.example.data.remote.apiServices.NewsApi
import com.example.data.remote.dtos.NewsDto
import com.example.data.utils.base.paging.BaseNewsPagingSource
import com.example.domain.model.NewsModel

class NewsPagingSource(private val apiService: NewsApi) :
    BaseNewsPagingSource<NewsDto, NewsModel>({
        apiService.getNews(page = it)
    })