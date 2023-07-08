package com.example.marvelappremastered.presentation.ui.fragments.sign.reg

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentRegBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegFragment  :
    BaseFragment<FragmentRegBinding, RegViewModel>(R.layout.fragment_reg) {

    override val binding by viewBinding(FragmentRegBinding::bind)
    override val viewModel : RegViewModel by viewModels()
}