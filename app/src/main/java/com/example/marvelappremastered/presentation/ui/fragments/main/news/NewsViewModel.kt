package com.example.marvelappremastered.presentation.ui.fragments.main.news

import com.example.domain.usecases.GetNewsUseCase
import com.example.marvelappremastered.presentation.core.base.BaseViewModel
import com.example.marvelappremastered.presentation.model.toUi
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsUseCase: GetNewsUseCase) : BaseViewModel() {

    fun getNews() = getNewsUseCase().gatherPagingRequest { it.toUi() }
}