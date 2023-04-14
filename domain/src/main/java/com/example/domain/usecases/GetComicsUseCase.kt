package com.example.domain.usecases

import com.example.domain.repository.ComicsRepository
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(private val repository: ComicsRepository) {

    operator fun invoke() = repository.getComics()
}