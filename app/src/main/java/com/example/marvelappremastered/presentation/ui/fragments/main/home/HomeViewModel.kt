package com.example.marvelappremastered.presentation.ui.fragments.main.home

import com.example.domain.usecases.GetFilmsUseCase
import com.example.marvelappremastered.presentation.core.base.BaseViewModel
import com.example.marvelappremastered.presentation.model.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getFilmsUseCase: GetFilmsUseCase) : BaseViewModel() {

    fun getFilms() = getFilmsUseCase().gatherPagingRequest { it.toUI() }
}