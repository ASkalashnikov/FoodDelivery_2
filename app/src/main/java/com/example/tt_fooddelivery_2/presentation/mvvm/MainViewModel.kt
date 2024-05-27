package com.example.tt_fooddelivery_2.presentation.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tt_fooddelivery_2.domain.model.BannerModel
import com.example.tt_fooddelivery_2.domain.model.MainModel
import com.example.tt_fooddelivery_2.domain.model.TagsModel
import com.example.tt_fooddelivery_2.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val context: Application,
    initSharedPreferencesUseCase: InitSharedPreferencesUseCase,
    private val getCityUseCase: GetCityUseCase,
    private val getRcViewBannerUseCase: GetRcViewBannerUseCase,
    private val getRcViewTagsUseCase: GetRcViewTagsUseCase,
    private val getAllMenuUseCase: GetAllMenuUseCase
) : AndroidViewModel(context) {

    private val _textCity = MutableLiveData<String>()
    val textCity: LiveData<String> = _textCity

    private val _rcViewBannerVM = MutableLiveData<ArrayList<BannerModel>>()
    val rcViewBannerVM: LiveData<ArrayList<BannerModel>> = _rcViewBannerVM

    private val _rcViewTagsVM = MutableLiveData<ArrayList<TagsModel>>()
    val rcViewTagsVM: LiveData<ArrayList<TagsModel>> = _rcViewTagsVM

    private val _rcViewMainVM = MutableLiveData<ArrayList<MainModel>>()
    val rcViewMainVM: LiveData<ArrayList<MainModel>> = _rcViewMainVM

    init {
        initSharedPreferencesUseCase.execute(context)
    }

    fun getCity() {
        // Получения текущего города
        CoroutineScope(Dispatchers.Main).launch {
            _textCity.value = getCityUseCase.execute(context)
        }
    }

    fun getBanner() {
        // Загрузка данных в RcView
        _rcViewBannerVM.value = getRcViewBannerUseCase.execute()
    }

    fun getTags() {
        // Загрузка данных в RcView
        _rcViewTagsVM.value = getRcViewTagsUseCase.execute()
    }

    suspend fun getMain() {
        // Загрузка данных в RcView
        _rcViewMainVM.value = getAllMenuUseCase.execute()
    }
}