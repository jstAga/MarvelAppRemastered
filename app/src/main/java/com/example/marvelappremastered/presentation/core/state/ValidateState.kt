package com.example.marvelappremastered.presentation.core.state

sealed class ValidateState() {
    class ValidateSuccess() : ValidateState()
    class CardNotSuccess(val message: String) : ValidateState()
    class DateNotSuccess(val message: String) : ValidateState()
    class CvNotSuccess(val message: String) : ValidateState()
}
