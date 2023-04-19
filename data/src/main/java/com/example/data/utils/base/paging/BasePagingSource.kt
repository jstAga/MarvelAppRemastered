package com.example.data.utils.base.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.utils.base.DataMapper
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


abstract class BasePagingSource<ValueDto : DataMapper<Value>, Value : Any>(
    private val request: suspend (position: Int) -> Response<BaseNews<ValueDto>>,
) : PagingSource<Int, Value>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Value> {
        val position = params.key ?: 1

        return try {
            val response = request(position)
            val data = response.body()?.results ?: emptyList()
            val responseData = mutableListOf<Value>()
            responseData.addAll(data.map { it.mapToDomain() })

            Log.e("aga", "PAGING: ${response.code()}", )
//            Log.e("aga", "PAGING: ${response.message()}", )
//            Log.e("aga", "PAGING: ${response.raw()}", )
//            Log.e("aga", "PAGING: ${response.errorBody()}", )
            Log.e("aga", "PAGING body: ${response.body()?.results}", )

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