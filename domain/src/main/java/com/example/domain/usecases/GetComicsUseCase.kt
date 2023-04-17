package com.example.domain.usecases

import com.example.domain.repository.ShopRepository
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(private val repository: ShopRepository) {

    operator fun invoke() = repository.getComics()
}