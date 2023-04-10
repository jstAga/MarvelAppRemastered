package com.example.marvelappremastered.presentation.ui.fragments.sign.reg

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentRegBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegFragment  :
    BaseFragment<FragmentRegBinding, com.example.marvelappremastered.presentation.ui.fragments.sign.reg.RegViewModel>(R.layout.fragment_reg) {

    override val binding by viewBinding(FragmentRegBinding::bind)
    override val viewModel by viewModel<com.example.marvelappremastered.presentation.ui.fragments.sign.reg.RegViewModel>()
}