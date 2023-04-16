package com.example.marvelappremastered.presentation.ui.fragments.main.comics

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentComicsBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import com.example.marvelappremastered.presentation.model.ComicUi
import com.example.marvelappremastered.presentation.ui.fragments.main.comics.adapter.ComicsPagingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment :
    BaseFragment<FragmentComicsBinding, ComicsViewModel>(R.layout.fragment_comics) {

    override val binding by viewBinding(FragmentComicsBinding::bind)
    override val viewModel: ComicsViewModel by viewModels()

    private val comicsAdapter by lazy { ComicsPagingAdapter(this::onSaveClick) }

    override fun initialize() {
        super.initialize()
        initAdapter()
    }

    override fun initSubscribers() {
        super.initSubscribers()
        viewModel.getComics().collectPaging { comicsAdapter.submitData(it) }
        viewModel.createComicState.collectUIState { Log.e("aga", "added: $it") }
    }

    private fun initAdapter() {
        with(binding.rvComics) {
            adapter = comicsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun onSaveClick(comicUi: ComicUi) {
        viewModel.createComic(comicUi)
    }
}