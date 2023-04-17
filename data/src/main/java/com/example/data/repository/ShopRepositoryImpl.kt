package com.example.data.repository

import androidx.paging.PagingData
import com.example.data.utils.base.BaseRepository
import com.example.data.remote.apiServices.MarvelApi
import com.example.data.remote.pagingSources.ComicsMarvelPagingSource
import com.example.domain.model.ComicModel
import com.example.domain.repository.ShopRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(private val apiService: MarvelApi) :
    BaseRepository(), ShopRepository {

    override fun getComics(): Flow<PagingData<ComicModel>> {
        return doPagingRequest(
            ComicsMarvelPagingSource(
                apiService = apiService
            ), pageSize = 20
        )
    }
}