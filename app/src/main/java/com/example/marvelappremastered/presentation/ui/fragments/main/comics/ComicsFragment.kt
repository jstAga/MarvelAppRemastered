package com.example.marvelappremastered.presentation.ui.fragments.main.comics

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentComicsBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import com.example.marvelappremastered.presentation.model.ComicUi
import com.example.marvelappremastered.presentation.ui.fragments.main.shop.adapter.LocalComicsPagingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment :
    BaseFragment<FragmentComicsBinding, ComicsViewModel>(R.layout.fragment_comics) {

    override val binding by viewBinding(FragmentComicsBinding::bind)
    override val viewModel: ComicsViewModel by viewModels()

    private val comicsAdapter by lazy { LocalComicsPagingAdapter(this::onClick) }

    override fun initialize() {
        super.initialize()
        initAdapter()
    }

    private fun initAdapter() {
        with(binding.rvComics) {
            adapter = comicsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun initRequest() {
        super.initRequest()
        readComics()
    }

    private fun readComics() {
        viewModel.readComics().collectPaging { comicsAdapter.submitData(it) }
    }

    private fun onClick(comic : ComicUi){
        Log.e("aga", "onClick: ${comic.title}", )
    }
}