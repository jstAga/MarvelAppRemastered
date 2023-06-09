package com.example.marvelappremastered.ui.fragments.onBoarding

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentOnBoardingBinding
import com.example.marvelappremastered.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnBoardingFragment :
    BaseFragment<FragmentOnBoardingBinding, OnBoardingViewModel>(R.layout.fragment_on_boarding) {

    override val binding by viewBinding(FragmentOnBoardingBinding::bind)
    override val viewModel by viewModel<OnBoardingViewModel>()
}