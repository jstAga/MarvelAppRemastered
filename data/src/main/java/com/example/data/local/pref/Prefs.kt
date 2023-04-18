package com.example.data.local.pref

import android.content.SharedPreferences
import com.example.data.utils.Constants.Companion.CREDIT_CARD
import com.example.data.utils.Constants.Companion.CV
import com.example.data.utils.Constants.Companion.VALID_THRU
import com.example.data.utils.base.sharedPref.put
import javax.inject.Inject

class Prefs @Inject constructor(private val sharedPreferences: SharedPreferences) {

    var creditCard: String?
        get() = sharedPreferences.getString(CREDIT_CARD, "")
        set(value) = sharedPreferences.put(CREDIT_CARD, value.toString())

    var validThru: String?
        get() = sharedPreferences.getString(VALID_THRU, "")
        set(value) = sharedPreferences.put(VALID_THRU, value.toString())

    var cv: String?
        get() = sharedPreferences.getString(CV, "")
        set(value) = sharedPreferences.put(CV, value.toString())
}