package com.example.tt_fooddelivery_2.data.repository.storageapi

import com.example.tt_fooddelivery_2.data.repository.storageapi.retrofit.AllMenuApi
import com.example.tt_fooddelivery_2.data.repository.storageapi.retrofit.AllMenuData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class GetAllMenuApi @Inject constructor() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://themealdb.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    suspend fun execute(): AllMenuData = withContext(Dispatchers.IO) {
        val api = retrofit.create(AllMenuApi::class.java)
        return@withContext api.getAllMenu()
    }
}