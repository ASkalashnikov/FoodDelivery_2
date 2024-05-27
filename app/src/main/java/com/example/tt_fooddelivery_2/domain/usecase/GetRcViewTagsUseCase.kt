package com.example.tt_fooddelivery_2.domain.usecase

import com.example.tt_fooddelivery_2.data.AppData
import com.example.tt_fooddelivery_2.domain.model.TagsModel
import javax.inject.Inject

class GetRcViewTagsUseCase @Inject constructor(private val appData: AppData) {

    fun execute(): ArrayList<TagsModel> {
        val list = ArrayList<TagsModel>()

        for (i in appData.tagsList.indices) {
            val data = TagsModel(appData.tagsList[i])
            list.add(data)
        }
        return list
    }
}