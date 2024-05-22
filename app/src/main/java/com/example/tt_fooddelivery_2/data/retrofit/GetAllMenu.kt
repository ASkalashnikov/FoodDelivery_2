package com.example.tt_fooddelivery_2.data.retrofit

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllMenu @Inject constructor() {
    lateinit var model: AllMenuData

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://themealdb.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    suspend fun execute() = withContext(Dispatchers.IO) {
        val api = retrofit.create(AllMenuApi::class.java)
        model = api.getAllMenu()
    }
}