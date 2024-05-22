package com.example.tt_fooddelivery_2.presentation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tt_fooddelivery_2.domain.model.BannerModel
import com.example.tt_fooddelivery_2.domain.model.MainModel
import com.example.tt_fooddelivery_2.domain.model.TagsModel
import com.example.tt_fooddelivery_2.domain.rcviewitems.RcViewBanner
import com.example.tt_fooddelivery_2.domain.rcviewitems.RcViewMain
import com.example.tt_fooddelivery_2.domain.rcviewitems.RcViewTags
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val rcViewBanner: RcViewBanner,
    private val rcViewTags: RcViewTags,
    private val rcViewMain: RcViewMain
) : ViewModel() {

    private val _rcViewBannerVM = MutableLiveData<ArrayList<BannerModel>>()
    val rcViewBannerVM: LiveData<ArrayList<BannerModel>> = _rcViewBannerVM

    private val _rcViewTagsVM = MutableLiveData<ArrayList<TagsModel>>()
    val rcViewTagsVM: LiveData<ArrayList<TagsModel>> = _rcViewTagsVM

    private val _rcViewMainVM = MutableLiveData<ArrayList<MainModel>>()
    val rcViewMainVM: LiveData<ArrayList<MainModel>> = _rcViewMainVM

    fun getBanner() {
        // Загрузка данных в RcView
        _rcViewBannerVM.value = rcViewBanner.init()
    }

    fun getTags() {
        // Загрузка данных в RcView
        _rcViewTagsVM.value = rcViewTags.init()
    }

    fun getMain() {
        // Загрузка данных в RcView
        _rcViewMainVM.value = rcViewMain.init()
    }
}