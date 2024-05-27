package com.example.tt_fooddelivery_2.data

import com.example.tt_fooddelivery_2.R
import javax.inject.Inject

class AppData @Inject constructor() {

    val imageBanner = listOf(
        R.drawable.banner,
        R.drawable.banner,
        R.drawable.banner,
        R.drawable.banner,
        R.drawable.banner
    )

    // Данные для тегов кнопок
    val tagsList = listOf("Пицца", "Комбо", "Десерты", "Напитки", "Закуски", "Коктейли", "Кофе")

    val imageMenuPizza = listOf(
        R.drawable.pizza_1,
        R.drawable.pizza_2,
        R.drawable.pizza_3,
        R.drawable.pizza_4,
        R.drawable.pizza_5,
        R.drawable.pizza_1,
        R.drawable.pizza_2,
        R.drawable.pizza_3,
        R.drawable.pizza_4,
        R.drawable.pizza_5
    )
}