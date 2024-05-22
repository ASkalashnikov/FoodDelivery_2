package com.example.tt_fooddelivery_2.domain.rcviewitems

import com.example.tt_fooddelivery_2.data.repository.AppData
import com.example.tt_fooddelivery_2.domain.model.TagsModel
import javax.inject.Inject

class RcViewTags @Inject constructor(){

    fun init(): ArrayList<TagsModel> {
        val list = ArrayList<TagsModel>()

        for (i in AppData.tagsList.indices) {
            val data = TagsModel(AppData.tagsList[i])
            list.add(data)
        }
        return list
    }
}