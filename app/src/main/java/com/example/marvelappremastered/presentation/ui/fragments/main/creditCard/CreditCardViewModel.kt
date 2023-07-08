package com.example.marvelappremastered.presentation.ui.fragments.main.creditCard

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvelappremastered.presentation.core.Constants.Companion.ERROR_CARD_LENGTH
import com.example.marvelappremastered.presentation.core.Constants.Companion.ERROR_CARD
import com.example.marvelappremastered.presentation.core.Constants.Companion.ERROR_DATE
import com.example.marvelappremastered.presentation.core.Constants.Companion.ERROR_MONTH
import com.example.marvelappremastered.presentation.core.Constants.Companion.ERROR_VALID
import com.example.marvelappremastered.presentation.core.Constants.Companion.ERROR_CV_LENGTH
import com.example.marvelappremastered.presentation.core.base.BaseViewModel
import com.example.marvelappremastered.presentation.core.state.ValidateState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CreditCardViewModel @Inject constructor() : BaseViewModel() {

    private var mutableResultValidate = MutableLiveData<ValidateState>()
    var liveResultValidate: LiveData<ValidateState> = mutableResultValidate

    fun validate(card: String, date: String, cv: String) {
        val cardResult = validateCard(card)
        val dateResult = validateDate(date)
        val cvResult = validateCv(cv)

        if (cardResult is ValidateState.ValidateSuccess &&
            dateResult is ValidateState.ValidateSuccess &&
            cvResult is ValidateState.ValidateSuccess
        ) {
            mutableResultValidate.value = ValidateState.ValidateSuccess()
        } else if (cardResult is ValidateState.CardNotSuccess) {
            mutableResultValidate.value = cardResult
        } else if (dateResult is ValidateState.DateNotSuccess) {
            mutableResultValidate.value = dateResult
        } else if (cvResult is ValidateState.CvNotSuccess) {
            mutableResultValidate.value = cvResult
        }
    }

    private fun validateCard(card: String): ValidateState {
        return if ((card[0] == '4' || card[0] == '5') && card.length == 19) {
            ValidateState.ValidateSuccess()
        } else if (card.length != 19) {
            ValidateState.CardNotSuccess(ERROR_CARD_LENGTH)
        } else {
            ValidateState.CardNotSuccess(ERROR_CARD)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun validateDate(date: String): ValidateState {
        if (date.length == 5) {
            val time = Calendar.getInstance().time
            val currentMonth = SimpleDateFormat("MM").format(time).toInt()
            val currentYear = SimpleDateFormat("yy").format(time).toInt()
            val cardYear = "${date[3]}${date[4]}".toInt()
            val cardMonth = "${date[0]}${date[1]}".toInt()

            if (cardMonth <= 12 &&
                (cardYear > currentYear || (cardYear >= currentYear && cardMonth > currentMonth))
            ) {
                return ValidateState.ValidateSuccess()
            } else if (cardMonth < 12) {
                return ValidateState.DateNotSuccess(ERROR_MONTH)
            } else if (cardYear < currentYear || (cardYear <= currentYear && cardMonth < currentMonth)) {
                return ValidateState.DateNotSuccess(ERROR_VALID)
            }
        }
        return ValidateState.DateNotSuccess(ERROR_DATE)
    }

    private fun validateCv(cv: String): ValidateState {
        return when (cv.length) {
            3 -> ValidateState.ValidateSuccess()
            else -> ValidateState.CvNotSuccess(ERROR_CV_LENGTH)
        }
    }
}