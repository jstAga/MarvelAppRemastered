package com.example.marvelappremastered.ui.fragments.creditCard

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentCreditCardBinding
import com.example.marvelappremastered.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreditCardFragment :
    BaseFragment<FragmentCreditCardBinding, CreditCardViewModel>(R.layout.fragment_credit_card) {

    override val binding by viewBinding(FragmentCreditCardBinding::bind)
    override val viewModel by viewModel<CreditCardViewModel>()
}