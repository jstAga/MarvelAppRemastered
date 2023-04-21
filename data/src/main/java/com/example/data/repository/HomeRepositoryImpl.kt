package com.example.data.repository

import com.example.data.remote.apiServices.ImdbApi
import com.example.data.remote.pagingSources.FilmsPagingSource
import com.example.data.utils.base.paging.BaseRepository
import com.example.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val apiService: ImdbApi) : HomeRepository,
    BaseRepository() {

    override fun getFilms() = doPagingRequest(FilmsPagingSource(apiService = apiService), pageSize = 1)
}