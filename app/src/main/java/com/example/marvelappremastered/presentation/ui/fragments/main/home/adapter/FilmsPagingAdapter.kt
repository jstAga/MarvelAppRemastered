package com.example.marvelappremastered.presentation.ui.fragments.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.data.utils.base.BaseDiffUtilItemCallback
import com.example.marvelappremastered.databinding.ItemFilmBinding
import com.example.marvelappremastered.presentation.model.FilmUi

class FilmsPagingAdapter (private val onFilmClick: (String) -> Unit) :
    PagingDataAdapter<FilmUi, FilmsPagingAdapter.ViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class ViewHolder(private val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: FilmUi) {
            with(binding) {
                ivImage.load(model.image)
                tvTitle.text = model.title
                itemView.setOnClickListener {
                    model.filmID?.let { it1 -> onFilmClick(it1) }
                }
            }
        }
    }
}