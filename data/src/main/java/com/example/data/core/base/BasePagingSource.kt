package com.example.data.core.base

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.core.DataMapper
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


abstract class BasePagingSource<ValueDto : DataMapper<Value>, Value : Any>(
    private val request: suspend (position: Int) -> Response<BasePagingResponse<ValueDto>>,
) : PagingSource<Int, Value>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Value> {
        val position = params.key ?: 1

        return try {
            val response = request(position)
            val data = response.body()?.results ?: emptyList()
            val responseData = mutableListOf<Value>()
            responseData.addAll(data.map { it.mapToDomain() })

            LoadResult.Page(
                data = responseData,
                prevKey = null,
                nextKey = position + 1
            )
        } catch (exception: IOException) {
            Log.e("aga", "PAGING load: "+ exception, )
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            Log.e("aga", "PAGING load: "+ exception, )
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Value>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}