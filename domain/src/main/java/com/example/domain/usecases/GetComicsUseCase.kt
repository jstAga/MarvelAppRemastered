package com.example.domain.usecases

import com.example.domain.repository.ComicsRepository

class GetComicsUseCase(private val repository: ComicsRepository) {

    operator fun invoke() = repository.getComics()
}