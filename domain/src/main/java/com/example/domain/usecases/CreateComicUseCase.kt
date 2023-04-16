package com.example.domain.usecases

import com.example.domain.model.Comic
import com.example.domain.repository.RoomRepository
import javax.inject.Inject

class CreateComicUseCase @Inject constructor(private val roomRepository: RoomRepository) {

    operator fun invoke(comic: Comic) = roomRepository.createComic(comic)
}