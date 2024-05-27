package com.example.tt_fooddelivery_2.domain.usecase

import android.content.Context
import com.example.tt_fooddelivery_2.data.repository.sharedpreferences.SharedPref
import javax.inject.Inject

class InitSharedPreferencesUseCase @Inject constructor(private val sharedPref: SharedPref) {

    fun execute(context: Context) {
        sharedPref.init(context)
    }
}