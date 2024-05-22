package com.example.tt_fooddelivery_2.domain.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_fooddelivery_2.databinding.ItemMainBinding
import com.example.tt_fooddelivery_2.domain.model.MainModel
import com.squareup.picasso.Picasso

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainHolder>() {
    private val list = ArrayList<MainModel>()

    class MainHolder(private val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(mainModel: MainModel) = with(binding) {
            textTitle.text = mainModel.title
            textDescription.text = mainModel.description
            textPrice.text = mainModel.price.toString()
            Picasso.get().load(mainModel.image).into(imageMain)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainBinding.inflate(inflater, parent, false)
        return MainHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(list[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(listItem: List<MainModel>) {
        list.addAll(listItem)
        notifyDataSetChanged()
    }
}