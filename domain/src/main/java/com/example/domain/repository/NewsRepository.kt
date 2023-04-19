package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews() : Flow<PagingData<NewsModel>>
}