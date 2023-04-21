package com.example.marvelappremastered.presentation.ui.fragments.main.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentHomeBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import com.example.marvelappremastered.presentation.core.navigateSafely
import com.example.marvelappremastered.presentation.ui.fragments.main.home.adapter.FilmsPagingAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel : HomeViewModel by viewModels()

    private val filmsAdapter by lazy { FilmsPagingAdapter(this::onFilmClick) }

    override fun initialize() {
        initAdapter()
    }

    override fun initRequest() {
        viewModel.getFilms().collectPaging { filmsAdapter.submitData(it) }
    }

    override fun initListeners() {
        binding.btnNews.setOnClickListener {
            findNavController().navigateSafely(R.id.action_homeFragment_to_newsFragment)
        }
    }

    private fun initAdapter() {
        with(binding.rvFilms){
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun onFilmClick(filmId: String){}
}