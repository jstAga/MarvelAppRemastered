package com.example.marvelappremastered.presentation.ui.fragments.main.onBoarding

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentOnBoardingBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment :
    BaseFragment<FragmentOnBoardingBinding, OnBoardingViewModel>(R.layout.fragment_on_boarding) {

    override val binding by viewBinding(FragmentOnBoardingBinding::bind)
    override val viewModel : OnBoardingViewModel by viewModels()
}