package com.greenmarket.app.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder>(diffCallBack: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, VH>(diffCallBack) {

    private val itemList = mutableListOf<T>()

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = itemList[position]
        onBindData(holder, item)
    }

    abstract fun onBindData(holder: VH, item: T)

    fun createList(items: List<T>){
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }
}