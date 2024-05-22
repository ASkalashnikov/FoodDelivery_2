package com.example.tt_fooddelivery_2.data.retrofit

import retrofit2.http.GET

interface AllMenuApi {

    @GET("api/json/v1/1/categories.php")
    suspend fun getAllMenu() : AllMenuData
}