package com.example.data.remote.apiServices

import com.example.data.utils.base.paging.BaseMarvel
import com.example.data.utils.base.paging.BasePagingResponse
import com.example.data.utils.Constants
import com.example.data.remote.dtos.ComicDto
import com.example.data.utils.Constants.Companion.PAGING_LIMIT
import com.example.data.utils.Constants.Companion.MARVEL_API_KEY
import com.example.data.utils.Constants.Companion.timeStamp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("offset") offset: Int,
        @Query("ts") ts: String = timeStamp,
        @Query("apikey") apikey: String = MARVEL_API_KEY,
        @Query("hash") hash: String = Constants.hash(),
        @Query("limit") limit: String = PAGING_LIMIT,
    ): Response<BaseMarvel<BasePagingResponse<ComicDto>>>
}