package com.example.tt_fooddelivery_2.domain.rcviewitems

import com.example.tt_fooddelivery_2.data.retrofit.GetAllMenu
import com.example.tt_fooddelivery_2.domain.model.MainModel
import javax.inject.Inject
import kotlin.random.Random

class RcViewMain @Inject constructor(private val getAllMenu: GetAllMenu) {

    fun init(): ArrayList<MainModel> {
        val list = ArrayList<MainModel>()

        for (i in getAllMenu.model.categories.indices) {
            val data = MainModel(
                id = getAllMenu.model.categories[i].idCategory,
                title = getAllMenu.model.categories[i].strCategory,
                description = getAllMenu.model.categories[i].strCategoryDescription,
                image = getAllMenu.model.categories[i].strCategoryThumb,
                price = 300 + Random.nextInt(200)
            )
            list.add(data)
        }
        return list



    }

}