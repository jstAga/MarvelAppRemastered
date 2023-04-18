package com.example.marvelappremastered.presentation.ui.fragments.main.creditCard

import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.data.local.pref.Prefs
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentCreditCardBinding
import com.example.marvelappremastered.presentation.core.Constants.Companion.MASTER_CARD
import com.example.marvelappremastered.presentation.core.Constants.Companion.VISA
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import com.example.marvelappremastered.presentation.core.state.ValidateState
import com.vicmikhailau.maskededittext.MaskedFormatter
import com.vicmikhailau.maskededittext.MaskedWatcher
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class CreditCardFragment :
    BaseFragment<FragmentCreditCardBinding, CreditCardViewModel>(R.layout.fragment_credit_card) {

    override val binding by viewBinding(FragmentCreditCardBinding::bind)
    override val viewModel: CreditCardViewModel by viewModels()

    private val cardFormatter by lazy { MaskedFormatter("#### #### #### ####") }
    private val validFormatter by lazy { MaskedFormatter("##/##") }

    @Inject
    lateinit var prefs: Prefs

    override fun initialize() {
        super.initialize()
        initFormatters()
    }

    override fun initListeners() {
        super.initListeners()
        setCard()
        setValid()
        validate()
    }

    private fun initFormatters() {
        with(binding) {
            etCard.addTextChangedListener(MaskedWatcher(cardFormatter, etCard))
            etValidThru.addTextChangedListener(MaskedWatcher(validFormatter, etValidThru))
        }
    }

    private fun setCard() {
        with(binding) {
            etCard.doAfterTextChanged { card ->
                tvCard.text = card.toString()
                if (card.toString().isNotEmpty()) {
                    when (card.toString()[0]) {
                        VISA -> ivCardLogo.load(R.drawable.img_visa)
                        MASTER_CARD -> ivCardLogo.load(R.drawable.img_mastercard)
                        else -> ivCardLogo.load(0)
                    }
                }
            }
        }
    }

    private fun setValid() {
        with(binding) {
            etValidThru.doAfterTextChanged { valid ->
                tvValid.text = valid.toString()
            }
        }
    }

    override fun initSubscribers() {
        super.initSubscribers()
        viewModel.liveResultValidate.observe(viewLifecycleOwner) { result ->
            with(binding) {
                when (result) {
                    is ValidateState.CardNotSuccess -> etCard.error = result.message
                    is ValidateState.DateNotSuccess -> etValidThru.error = result.message
                    is ValidateState.CvNotSuccess -> etCv.error = result.message
                    is ValidateState.ValidateSuccess -> {
                        prefs.creditCard = etCard.text.toString()
                        prefs.validThru = etValidThru.text.toString()
                        prefs.cv = etCv.text.toString()
                        findNavController().navigateUp()
                    }
                }
            }
        }
    }

    private fun validate() {
        with(binding) {
            btnConfirm.setOnClickListener {
                viewModel.validate(etCard.text.toString(), etValidThru.text.toString(), etCv.text.toString())
            }
        }
    }
}