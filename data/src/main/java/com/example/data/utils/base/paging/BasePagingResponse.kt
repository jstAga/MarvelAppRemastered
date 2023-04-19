package com.example.data.utils.base.paging

import com.google.gson.annotations.SerializedName

open class BasePagingResponse<T>(
    @SerializedName("next")
    val next: Int?,
    @SerializedName("results")
    val results: MutableList<T>
)

open class BaseMarvel<T>(
    @SerializedName("data")
    val data : T
)

open class BaseNews<T>(
    @SerializedName("next")
    val next: Int?,
    @SerializedName("articles")
    val results: MutableList<T>
)