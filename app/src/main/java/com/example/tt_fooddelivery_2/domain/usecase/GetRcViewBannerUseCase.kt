package com.example.tt_fooddelivery_2.domain.usecase

import com.example.tt_fooddelivery_2.data.AppData
import com.example.tt_fooddelivery_2.domain.model.BannerModel
import javax.inject.Inject

class GetRcViewBannerUseCase @Inject constructor(private val appData: AppData) {

    fun execute(): ArrayList<BannerModel> {
        val list = ArrayList<BannerModel>()

        for (i in appData.imageBanner.indices) {
            val data = BannerModel(appData.imageBanner[i])
            list.add(data)
        }
        return list
    }
}