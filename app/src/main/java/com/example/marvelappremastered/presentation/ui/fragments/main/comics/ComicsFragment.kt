package com.example.marvelappremastered.presentation.ui.fragments.main.comics

import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentComicsBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import com.example.marvelappremastered.presentation.ui.fragments.main.comics.adapter.ComicsPagingAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComicsFragment :
    BaseFragment<FragmentComicsBinding, ComicsViewModel>(R.layout.fragment_comics) {

    override val binding by viewBinding(FragmentComicsBinding::bind)
    override val viewModel by viewModel<ComicsViewModel>()

    private val comicsAdapter by lazy {ComicsPagingAdapter()}

    override fun initialize() {
        super.initialize()
        initAdapter()
    }

    override fun initSubscribers() {
        super.initSubscribers()
        viewModel.getComics().collectPaging { comicsAdapter.submitData(it) }
    }

    private fun initAdapter() {
        with(binding.rvComics) {
            adapter = comicsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}