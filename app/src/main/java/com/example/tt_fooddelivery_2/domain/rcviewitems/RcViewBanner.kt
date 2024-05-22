package com.example.tt_fooddelivery_2.domain.rcviewitems

import com.example.tt_fooddelivery_2.data.repository.AppData
import com.example.tt_fooddelivery_2.domain.model.BannerModel
import javax.inject.Inject

class RcViewBanner @Inject constructor() {

    fun init(): ArrayList<BannerModel> {
        val list = ArrayList<BannerModel>()

        for (i in AppData.image_banner.indices) {
            val data = BannerModel(AppData.image_banner[i])
            list.add(data)
        }
        return list
    }
}