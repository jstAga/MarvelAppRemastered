package com.example.data.utils.base

interface DataMapper<T> {
    fun mapToDomain(): T
}