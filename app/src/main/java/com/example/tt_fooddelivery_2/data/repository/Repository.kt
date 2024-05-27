package com.example.tt_fooddelivery_2.data.repository

import com.example.tt_fooddelivery_2.data.repository.sharedpreferences.SharedPref
import com.example.tt_fooddelivery_2.data.repository.storageapi.GetAllMenuApi
import com.example.tt_fooddelivery_2.domain.model.MainModel
import java.io.IOException
import javax.inject.Inject
import kotlin.random.Random

class Repository @Inject constructor(
    private val getAllMenuApi: GetAllMenuApi,
    private val sharedPref: SharedPref
    ) {

    suspend fun requestData(): ArrayList<MainModel> {
        val listData = try {
            getApi()
        } catch (e: IOException) {
            e.printStackTrace()
            getSharedPreferences()
        }
        return listData
    }

    private suspend fun getApi(): ArrayList<MainModel> {
        val list = ArrayList<MainModel>()

        val dataApi = getAllMenuApi.execute()

        for (i in dataApi.categories.indices) {
            val mainModel = MainModel(
                id = dataApi.categories[i].idCategory,
                title = dataApi.categories[i].strCategory,
                description = dataApi.categories[i].strCategoryDescription,
                image = dataApi.categories[i].strCategoryThumb,
                price = 300 + Random.nextInt(200)
            )
            list.add(mainModel)

            // Каждый раз сохраняем в SharedPref для Offline
            saveSharedPreferences(i, mainModel)
        }
        return list
    }

    private fun getSharedPreferences(): ArrayList<MainModel> {
        val list = ArrayList<MainModel>()

        for (i in 0..sharedPref.getInt("endPosition")) {
            val mainModel = MainModel(
                id = sharedPref.getInt("${i}0"),
                title = sharedPref.getString("${i}1"),
                description = sharedPref.getString("${i}2"),
                image = sharedPref.getString("${i}3"),
                price = sharedPref.getInt("${i}4")
            )
            list.add(mainModel)
        }
        return list
    }

    private fun saveSharedPreferences(i: Int, mainModel: MainModel) {
        sharedPref.saveInt("${i}0", mainModel.id)
        sharedPref.saveString("${i}1", mainModel.title)
        sharedPref.saveString("${i}2", mainModel.description)
        sharedPref.saveString("${i}3", mainModel.image)
        sharedPref.saveInt("${i}4", mainModel.price)

        // Save end position
        sharedPref.saveInt("endPosition", i)
    }
}