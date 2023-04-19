package com.example.domain.usecases

import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val repository: NewsRepository) {

    operator fun invoke() = repository.getNews()
}