package com.example.marvelappremastered.presentation.ui.fragments.main.shop

import com.example.domain.usecases.ReadComicsUseCase
import com.example.marvelappremastered.presentation.core.base.BaseViewModel
import com.example.marvelappremastered.presentation.model.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val readComicsUseCase: ReadComicsUseCase,
) : BaseViewModel() {

    fun readComics() =  readComicsUseCase().gatherPagingRequest { it.toUI() }
}