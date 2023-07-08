package com.example.marvelappremastered.presentation.ui.fragments.sign.auth

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentAuthBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment :
    BaseFragment<FragmentAuthBinding, AuthViewModel>(R.layout.fragment_auth) {

    override val binding by viewBinding(FragmentAuthBinding::bind)
    override val viewModel: AuthViewModel by viewModels()
}