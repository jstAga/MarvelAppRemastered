package com.example.marvelappremastered.presentation.ui.fragments.main.comics

import com.example.domain.usecases.ReadComicsUseCase
import com.example.marvelappremastered.presentation.model.toUI
import com.example.marvelappremastered.presentation.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val readComicsUseCase: ReadComicsUseCase,
) : BaseViewModel() {

    fun readComics() = readComicsUseCase().gatherPagingRequest { it.toUI() }
}