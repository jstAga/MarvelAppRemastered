package com.example.marvelappremastered.presentation.ui.fragments.main.comics

import com.example.domain.usecases.GetComicsUseCase
import com.example.marvelappremastered.presentation.model.toUI
import com.example.marvelappremastered.presentation.core.base.BaseViewModel

class ComicsViewModel(private val getComicsUseCase: GetComicsUseCase) : BaseViewModel() {

    fun getComics() = getComicsUseCase().gatherPagingRequest { it.toUI() }
}