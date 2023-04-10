package com.example.marvelappremastered.presentation.ui.fragments.main.comics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.data.core.base.BaseDiffUtilItemCallback
import com.example.marvelappremastered.databinding.ItemComicBinding
import com.example.marvelappremastered.presentation.model.ComicUi

class ComicsPagingAdapter :
    PagingDataAdapter<ComicUi, ComicsPagingAdapter.ViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemComicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class ViewHolder(private val binding: ItemComicBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ComicUi) {
            with(binding) {
                ivImage.load(model.image)
                tvTitle.text = model.title
            }
        }
    }
}