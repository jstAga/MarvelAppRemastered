package com.example.domain.usecases

import com.example.domain.model.Comic
import com.example.domain.repository.ComicsRepository
import javax.inject.Inject

class CreateComicUseCase @Inject constructor(private val comicsRepository: ComicsRepository) {

    operator fun invoke(comic: Comic) = comicsRepository.createComic(comic)
}