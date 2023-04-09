package com.example.marvelappremastered.ui.fragments.shop

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentShopBinding
import com.example.marvelappremastered.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShopFragment :
    BaseFragment<FragmentShopBinding, ShopViewModel>(R.layout.fragment_shop) {

    override val binding by viewBinding(FragmentShopBinding::bind)
    override val viewModel by viewModel<ShopViewModel>()
}