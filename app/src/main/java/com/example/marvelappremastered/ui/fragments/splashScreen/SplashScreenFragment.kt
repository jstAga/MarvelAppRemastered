package com.example.marvelappremastered.ui.fragments.splashScreen

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentSplashScreenBinding
import com.example.marvelappremastered.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenFragment :
    BaseFragment<FragmentSplashScreenBinding, SplashScreenViewModel>(R.layout.fragment_auth) {

    override val binding by viewBinding(FragmentSplashScreenBinding::bind)
    override val viewModel by viewModel<SplashScreenViewModel>()
}