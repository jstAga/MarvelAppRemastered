package com.example.data.core.base

import com.google.gson.annotations.SerializedName

open class BasePagingResponse<T>(
    @SerializedName("next")
    val next: Int?,
    @SerializedName("results")
    val results: MutableList<T>
)