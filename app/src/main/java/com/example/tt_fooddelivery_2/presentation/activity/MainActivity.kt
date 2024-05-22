package com.example.tt_fooddelivery_2.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_fooddelivery_2.R
import com.example.tt_fooddelivery_2.data.retrofit.GetAllMenu
import com.example.tt_fooddelivery_2.databinding.ActivityMainBinding
import com.example.tt_fooddelivery_2.domain.adapter.BannerAdapter
import com.example.tt_fooddelivery_2.domain.adapter.MainAdapter
import com.example.tt_fooddelivery_2.domain.adapter.TagsAdapter
import com.example.tt_fooddelivery_2.presentation.mvvm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), TagsAdapter.InterfaceTags {
    private lateinit var binding: ActivityMainBinding
    private val mvvm: MainViewModel by viewModels()
    private val adapterBanner = BannerAdapter()
    private val adapterTags = TagsAdapter(this@MainActivity)
    private val adapterMain = MainAdapter()
    @Inject
    lateinit var getAllMenu: GetAllMenu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.Main).launch {
            // Retrofit, загружаем данные с api
            getAllMenu.execute()
            // Загружаем данные в LiveData
            mvvm.getBanner()
            mvvm.getTags()
            mvvm.getMain()

            initRcViewBanner()
            initRcViewTags()
            initRcViewMain()
            appBarScroll()
        }
    }

    private fun initRcViewBanner() = with(binding) {
        rcViewBanner.layoutManager =
            LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
        rcViewBanner.adapter = adapterBanner
        mvvm.rcViewBannerVM.observe(this@MainActivity) { adapterBanner.updateAdapter(it) }
    }

    private fun initRcViewTags() = with(binding) {
        rcViewTags.layoutManager =
            LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
        rcViewTags.adapter = adapterTags
        mvvm.rcViewTagsVM.observe(this@MainActivity) {  adapterTags.updateAdapter(it) }
    }

    private fun initRcViewMain() = with(binding) {
        rcViewMain.layoutManager = LinearLayoutManager(this@MainActivity)
        rcViewMain.adapter = adapterMain
        mvvm.rcViewMainVM.observe(this@MainActivity) { adapterMain.updateAdapter(it) }
    }

    override fun onClickTags(adapterPosition: Int) {
        // Обновляем адаптер
        adapterTags.update()
    }

    // Меняем цвет
    private fun appBarScroll() = with(binding) {
        binding.appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            var backgroundColor = 0

            when (verticalOffset) {
                in 0 downTo -199 -> { backgroundColor = R.color.background_screen_1 }
                in -200 downTo -249 -> { backgroundColor = R.color.background_scroll_appbar_1 }
                in -250 downTo -299 -> { backgroundColor = R.color.background_scroll_appbar_2 }
                in -300 downTo -999 -> { backgroundColor = R.color.background_scroll_appbar_finish }
            }

            includeToolbar.toolbarScreen1.setBackgroundColor(getColor(backgroundColor))
            appBar.setBackgroundColor(getColor(backgroundColor))
            rcViewTags.setBackgroundColor(getColor(backgroundColor))
        }
    }
}