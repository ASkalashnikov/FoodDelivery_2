package com.example.tt_fooddelivery_2.domain.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.core.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_fooddelivery_2.R
import com.example.tt_fooddelivery_2.databinding.ItemMainTagsBinding
import com.example.tt_fooddelivery_2.domain.management.AppContext
import com.example.tt_fooddelivery_2.domain.model.TagsModel

class TagsAdapter(private val interfaceTags: InterfaceTags) : RecyclerView.Adapter<TagsAdapter.TagsHolder>() {
    private val list = ArrayList<TagsModel>()

    class TagsHolder(private val binding: ItemMainTagsBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind(data: TagsModel, interfaceTags: InterfaceTags) = with(binding) {
            textTags.text = data.tags

            // Проверяем, была ли кнопка активная (default AppContext.positionActiveTags = 0)
            // Делаем активную кнопку
            if (adapterPosition == AppContext.positionRcViewTags) {
                textTags.setTextColor(getColor(textTags.context, R.color.text_tags_active))
                cardViewTags.setCardBackgroundColor(getColor(cardViewTags.context, R.color.card_view_tags_active))
                cardViewTags.cardElevation = 0f
            } else {
                // Делаем не активную кнопку
                textTags.setTextColor(getColor(textTags.context, R.color.text_tags_not_active))
                cardViewTags.setCardBackgroundColor(getColor(cardViewTags.context, R.color.card_view_tags_not_active))
                cardViewTags.cardElevation = 5f
            }

            itemView.setOnClickListener {
                // Сохраняем позицию активной кнопки
                AppContext.positionRcViewTags = adapterPosition
                // Для реализации onClick во фрагменте
                interfaceTags.onClickTags(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainTagsBinding.inflate(inflater, parent, false)
        return TagsHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TagsHolder, position: Int) {
        holder.bind(list[position], interfaceTags)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(listItem: List<TagsModel>) {
        list.addAll(listItem)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update() {
        notifyDataSetChanged()
    }

    interface InterfaceTags {
        fun onClickTags(adapterPosition: Int)
    }
}