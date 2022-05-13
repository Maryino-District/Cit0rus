package com.example.cit0rustest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cit0rustest.BR
import com.example.cit0rustest.utils.LayerItemDiffCallBack
import com.example.cit0rustest.vm.GroupViewModel
import com.example.cit0rustest.vm.ItemViewModel
import com.example.cit0rustest.vm.LayerViewModel
import com.google.gson.Gson


class LayersRecyclerVIewAdapter : RecyclerView.Adapter<LayersViewHolder>() {

    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()
    val mItemViewModels: MutableList<ItemViewModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LayersViewHolder {
        println("---oncreateview")
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?: 0,
            parent,
            false
        )
        return LayersViewHolder(binding)
    }

    fun submitList(updatedList: List<ItemViewModel>) {
        println("---sub")
        val differCallBack = LayerItemDiffCallBack(mItemViewModels, updatedList)
        val diffResult = DiffUtil.calculateDiff(differCallBack, true)
        mItemViewModels.clear()
        for (items in updatedList) {
            val tmp = Gson().toJson(items)
            if (items is LayerViewModel) {
                mItemViewModels.add(Gson().fromJson(tmp, LayerViewModel::class.java))
            } else {
                mItemViewModels.add(Gson().fromJson(tmp, GroupViewModel::class.java))
            }
        }
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemViewType(position: Int): Int {
        println("---getItemViewType")
        val item = mItemViewModels[position]
        if (!viewTypeToLayoutId.containsKey(item.viewType)) {
            viewTypeToLayoutId[item.viewType] = item.layoutId
        }
        return item.viewType
    }

    override fun onBindViewHolder(holder: LayersViewHolder, position: Int) {
        println("tag onBindViewHolder positiion is ${position}")
        holder.bind(mItemViewModels[position])
    }

    override fun getItemCount(): Int {
        println("---getItemCount")
        return mItemViewModels.size
    }


    fun updateItems(items: List<ItemViewModel>?) {
        println("---updateItems")
        items?.let { submitList(items) }
    }

}

class LayersViewHolder(
    val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemViewModel: ItemViewModel) {
        binding.setVariable(BR.itemViewModel, itemViewModel)
        println("---bind")
    }
}

