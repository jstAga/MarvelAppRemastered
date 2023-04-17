package com.example.data.remote.apiServices

import com.example.data.utils.base.BaseMarvel
import com.example.data.utils.base.BasePagingResponse
import com.example.data.utils.Constants
import com.example.data.remote.dtos.ComicDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("offset") offset: Int,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("apikey") apikey: String = Constants.MARVEL_API_KEY,
        @Query("hash") hash: String = Constants.hash(),
        @Query("limit") limit: String = Constants.LIMIT,
    ): Response<BaseMarvel<BasePagingResponse<ComicDto>>>
}