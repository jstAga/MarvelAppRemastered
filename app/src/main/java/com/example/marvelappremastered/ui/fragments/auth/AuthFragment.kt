package com.example.marvelappremastered.ui.fragments.auth

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentAuthBinding
import com.example.marvelappremastered.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment :
    BaseFragment<FragmentAuthBinding, AuthViewModel>(R.layout.fragment_auth) {

    override val binding by viewBinding(FragmentAuthBinding::bind)
    override val viewModel by viewModel<AuthViewModel>()
}