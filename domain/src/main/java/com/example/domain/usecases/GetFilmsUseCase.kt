package com.example.domain.usecases

import com.example.domain.repository.HomeRepository
import javax.inject.Inject

class GetFilmsUseCase @Inject constructor(private val repository: HomeRepository) {

    operator fun invoke() = repository.getFilms()
}