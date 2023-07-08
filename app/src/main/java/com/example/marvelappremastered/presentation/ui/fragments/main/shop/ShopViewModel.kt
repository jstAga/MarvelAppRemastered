package com.example.marvelappremastered.presentation.ui.fragments.main.shop

import com.example.domain.usecases.CreateComicUseCase
import com.example.domain.usecases.GetComicsUseCase
import com.example.marvelappremastered.presentation.core.base.BaseViewModel
import com.example.marvelappremastered.presentation.core.state.UIState
import com.example.marvelappremastered.presentation.model.ComicUi
import com.example.marvelappremastered.presentation.model.toDomain
import com.example.marvelappremastered.presentation.model.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val getComicsUseCase: GetComicsUseCase,
    private val createComicUseCase: CreateComicUseCase,
//    private val deleteComicUseCase: DeleteComicUseCase,
) : BaseViewModel()

{

    private val _createComicState = MutableStateFlow<UIState<Unit>>(UIState.Idle())
    val createComicState = _createComicState.asStateFlow()

//    private val _deleteComicState = MutableStateFlow<UIState<Unit>>(UIState.Idle())
//    val deleteComicState = _deleteComicState.asStateFlow()

    fun getComics() = getComicsUseCase().gatherPagingRequest { it.toUI() }

    fun createComic(comicUi: ComicUi) =
            createComicUseCase(comicUi.toDomain()).collectFlow(_createComicState)

//    fun deleteComic(comic: Comic) = deleteComicUseCase(comic).collectFlow(_deleteComicState)
}