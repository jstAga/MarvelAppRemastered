package com.example.domain.usecases

import com.example.domain.model.Comic
import com.example.domain.repository.RoomRepository
import javax.inject.Inject

class DeleteComicUseCase @Inject constructor(private val repository: RoomRepository) {

    operator fun invoke(comic: Comic) = repository.deleteComic(comic)
}