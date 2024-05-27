package com.example.tt_fooddelivery_2.data.repository.storageapi.retrofit

data class AllMenuData(
    val categories: List<Menu>
)

data class Menu(
    val idCategory: Int,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)
