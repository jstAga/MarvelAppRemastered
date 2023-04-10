package com.example.marvelappremastered.presentation.ui.fragments.sign.auth

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentAuthBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment :
    BaseFragment<FragmentAuthBinding, com.example.marvelappremastered.presentation.ui.fragments.sign.auth.AuthViewModel>(R.layout.fragment_auth) {

    override val binding by viewBinding(FragmentAuthBinding::bind)
    override val viewModel by viewModel<com.example.marvelappremastered.presentation.ui.fragments.sign.auth.AuthViewModel>()
}