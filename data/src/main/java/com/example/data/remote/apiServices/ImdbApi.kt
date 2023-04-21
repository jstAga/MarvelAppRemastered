package com.example.data.remote.apiServices

import com.example.data.remote.dtos.FilmDto
import com.example.data.utils.Constants.Companion.IMDB_API_KEY
import com.example.data.utils.Constants.Companion.IMDB_COUNTRY
import com.example.data.utils.Constants.Companion.IMDB_HOST
import com.example.data.utils.Constants.Companion.IMDB_KEYWORD
import com.example.data.utils.Constants.Companion.IMDB_RUNTIME
import com.example.data.utils.Constants.Companion.IMDB_TITLE
import com.example.data.utils.Constants.Companion.IMDB_TYPE
import com.example.data.utils.Constants.Companion.IMDB_USER_RATING
import com.example.data.utils.base.paging.BasePagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ImdbApi {

    @GET("title/v2/find")
    suspend fun getFilms(
        @Query("paginationKey") paginationKey: Int,
        @Query("title") title: String = IMDB_TITLE,
        @Query("titleType") titleType: String = IMDB_TYPE,
        @Query("limit") limit: Int = 5,
        @Query("runtimeMin") runtimeMin: Int = IMDB_RUNTIME,
        @Query("userRatingMin") userRatingMin: Int = IMDB_USER_RATING,
        @Query("keyword") keyword: String = IMDB_KEYWORD,
        @Query("primaryCountry") primaryCountry: String = IMDB_COUNTRY,
        @Header("X-RapidAPI-Key") key: String = IMDB_API_KEY,
        @Header("X-RapidAPI-Host") host: String = IMDB_HOST,
    ): Response<BasePagingResponse<FilmDto>>
}