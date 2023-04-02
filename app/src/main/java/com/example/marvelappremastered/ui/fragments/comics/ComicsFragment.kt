package com.example.marvelappremastered.ui.fragments.comics

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentComicsBinding
import com.example.marvelappremastered.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComicsFragment :
    BaseFragment<FragmentComicsBinding, ComicsViewModel>(R.layout.fragment_auth) {

    override val binding by viewBinding(FragmentComicsBinding::bind)
    override val viewModel by viewModel<ComicsViewModel>()
}