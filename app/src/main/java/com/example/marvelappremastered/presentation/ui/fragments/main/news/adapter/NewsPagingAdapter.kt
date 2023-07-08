package com.example.marvelappremastered.presentation.ui.fragments.main.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.data.utils.base.BaseDiffUtilItemCallback
import com.example.marvelappremastered.databinding.ItemNewsBinding
import com.example.marvelappremastered.presentation.model.NewsUi

class NewsPagingAdapter (private val onNewsClick: (String) -> Unit) :
    PagingDataAdapter<NewsUi, NewsPagingAdapter.ViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class ViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: NewsUi) {
            with(binding) {
                ivImage.load(model.urlToImage)
                tvDesc.text = model.title
                tvPublished.text = model.publishedAt
                itemView.setOnClickListener {
                    model.url?.let { it1 -> onNewsClick(it1) }
                }
            }
        }
    }
}