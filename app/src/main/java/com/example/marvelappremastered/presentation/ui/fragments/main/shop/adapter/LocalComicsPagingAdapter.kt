package com.example.marvelappremastered.presentation.ui.fragments.main.shop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.data.utils.base.BaseDiffUtilItemCallback
import com.example.marvelappremastered.databinding.ItemShopBinding
import com.example.marvelappremastered.presentation.model.ComicUi


class LocalComicsPagingAdapter(private val onComicClick: (ComicUi) -> Unit) :
    PagingDataAdapter<ComicUi, LocalComicsPagingAdapter.ViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onBindViewHolder(holder: LocalComicsPagingAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalComicsPagingAdapter.ViewHolder {
        return ViewHolder(
            ItemShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class ViewHolder(private val binding: ItemShopBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ComicUi) {
            with(binding) {
                ivImage.load(model.image)
                tvTitle.text = model.title
                itemView.setOnClickListener {
                    onComicClick(model)
                }
            }
        }
    }
}