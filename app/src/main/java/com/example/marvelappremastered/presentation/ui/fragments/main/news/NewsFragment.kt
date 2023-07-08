package com.example.marvelappremastered.presentation.ui.fragments.main.news

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentNewsBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import com.example.marvelappremastered.presentation.ui.fragments.main.news.adapter.NewsPagingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment :
    BaseFragment<FragmentNewsBinding, NewsViewModel>(R.layout.fragment_news) {

    override val binding by viewBinding(FragmentNewsBinding::bind)
    override val viewModel : NewsViewModel by viewModels()

    private val newsAdapter by lazy { NewsPagingAdapter(this::onNewsClick) }

    override fun initialize() {
        initAdapter()
    }

    override fun initRequest() {
        getNews()
    }


    private fun initAdapter() {
        with(binding.rvNews){
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun getNews() {
        viewModel.getNews().collectPaging { newsAdapter.submitData(it) }
    }

    private fun onNewsClick(url : String){}
}