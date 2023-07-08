package com.example.domain.usecases

import com.example.domain.repository.RoomRepository
import javax.inject.Inject

class ReadComicsUseCase @Inject constructor(private val repository: RoomRepository) {

    operator fun invoke() = repository.readComics()
}