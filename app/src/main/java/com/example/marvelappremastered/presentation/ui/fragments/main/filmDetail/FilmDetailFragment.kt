package com.example.marvelappremastered.presentation.ui.fragments.main.filmDetail

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentFilmDetailBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FilmDetailFragment :
    BaseFragment<FragmentFilmDetailBinding, FilmDetailViewModel>(R.layout.fragment_film_detail) {

    override val binding by viewBinding(FragmentFilmDetailBinding::bind)
    override val viewModel : FilmDetailViewModel by viewModels()
}