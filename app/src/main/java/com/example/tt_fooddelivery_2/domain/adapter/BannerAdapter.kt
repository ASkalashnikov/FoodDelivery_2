package com.example.tt_fooddelivery_2.domain.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_fooddelivery_2.databinding.ItemMainBannerBinding
import com.example.tt_fooddelivery_2.domain.model.BannerModel

class BannerAdapter: RecyclerView.Adapter<BannerAdapter.BannerHolder>() {
    private val list = ArrayList<BannerModel>()

    class BannerHolder(private val binding: ItemMainBannerBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(mainData: BannerModel) = with(binding) {
            imageBanner.setImageResource(mainData.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainBannerBinding.inflate(inflater, parent, false)
        return BannerHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BannerHolder, position: Int) {
        holder.bind(list[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(listItem: List<BannerModel>) {
        list.addAll(listItem)
        notifyDataSetChanged()
    }
}