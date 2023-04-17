package com.example.data.utils.base

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