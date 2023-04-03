package com.example.data.core

interface DataMapper<T> {
    fun mapToDomain(): T
}