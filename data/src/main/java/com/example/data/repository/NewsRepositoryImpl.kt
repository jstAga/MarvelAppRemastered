package com.example.data.repository

import com.example.data.remote.apiServices.NewsApi
import com.example.data.remote.pagingSources.NewsPagingSource
import com.example.data.utils.base.paging.BaseRepository
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val apiService: NewsApi) :
    NewsRepository, BaseRepository() {

    override fun getNews() = doPagingRequest(NewsPagingSource(apiService = apiService), pageSize = 1)
}