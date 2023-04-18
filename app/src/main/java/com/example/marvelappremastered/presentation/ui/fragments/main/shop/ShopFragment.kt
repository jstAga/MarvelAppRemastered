package com.example.marvelappremastered.presentation.ui.fragments.main.shop

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentShopBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import com.example.marvelappremastered.presentation.core.navigateSafely
import com.example.marvelappremastered.presentation.model.ComicUi
import com.example.marvelappremastered.presentation.ui.fragments.main.shop.adapter.ComicsPagingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment :
    BaseFragment<FragmentShopBinding, ShopViewModel>(R.layout.fragment_shop) {

    override val binding by viewBinding(FragmentShopBinding::bind)
    override val viewModel: ShopViewModel by viewModels()

    private val comicsAdapter by lazy { ComicsPagingAdapter(this::onSaveClick, this::onBuyClick) }

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
        with(binding.rvShop) {
            adapter = comicsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun onSaveClick(comicUi: ComicUi) {
        viewModel.createComic(comicUi)
    }

    private fun onBuyClick() {
        findNavController().navigateSafely(R.id.action_shopFragment_to_creditCardFragment)
    }
}