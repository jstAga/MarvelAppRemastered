package com.example.data.remote.dtos

import com.google.gson.annotations.SerializedName

open class BaseMarvel<T>(
    @SerializedName("data")
    val data : T
)