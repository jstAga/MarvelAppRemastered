package com.example.data.repository

import com.example.data.utils.base.paging.BaseRepository
import com.example.data.remote.apiServices.MarvelApi
import com.example.data.remote.pagingSources.ComicsPagingSource
import com.example.domain.repository.ShopRepository
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(private val apiService: MarvelApi) : ShopRepository,
    BaseRepository() {

    override fun getComics() = doPagingRequest(ComicsPagingSource(apiService = apiService), pageSize = 20)
}
