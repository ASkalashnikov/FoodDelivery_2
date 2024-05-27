package com.example.tt_fooddelivery_2.data.repository.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPref @Inject constructor() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences("Offline", Context.MODE_PRIVATE)
    }

    fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    fun saveInt(key: String, int: Int) {
        edit = sharedPreferences.edit()
        edit.putInt(key, int)
        edit.apply()
    }

    fun getString(key: String): String {
        return sharedPreferences.getString(key, "").toString()
    }

    fun saveString(key: String, string: String) {
        edit = sharedPreferences.edit()
        edit.putString(key, string)
        edit.apply()
    }
}