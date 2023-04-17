package com.example.marvelappremastered.presentation.ui.fragments.main.shop

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentShopBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import com.example.marvelappremastered.presentation.model.ComicUi
import com.example.marvelappremastered.presentation.ui.fragments.main.shop.adapter.LocalComicsPagingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment :
    BaseFragment<FragmentShopBinding, ShopViewModel>(R.layout.fragment_shop) {

    override val binding by viewBinding(FragmentShopBinding::bind)
    override val viewModel: ShopViewModel by viewModels()

    private val shopAdapter by lazy { LocalComicsPagingAdapter(this::onClick) }

    override fun initialize() {
        super.initialize()
        initAdapter()
    }

    private fun initAdapter() {
        with(binding.rvShop) {
            adapter = shopAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun initRequest() {
        super.initRequest()
        readComics()
    }

    private fun readComics() {
        viewModel.readComics().collectPaging { shopAdapter.submitData(it) }
    }

    private fun onClick(comic : ComicUi){
        Log.e("aga", "onClick: ${comic.title}", )
    }
}