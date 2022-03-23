package com.example.cit0rustest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.cit0rustest.vm.ItemViewModel
import com.example.cit0rustest.BR
import com.example.cit0rustest.vm.LayerListViewModel

class LayersRecyclerVIewAdapter : RecyclerView.Adapter<LayersViewHolder>() {
    //var itemViewModels: List<ItemViewModel> = emptyList()
    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()
    var itemViewModels: List<ItemViewModel> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LayersViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?:0,
            parent,
            false
        )
        return LayersViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemViewModels[position]
        if (!viewTypeToLayoutId.containsKey(item.viewType)) {
            viewTypeToLayoutId[item.viewType] = item.layoutId
        }
        return item.viewType
    }

    override fun onBindViewHolder(holder: LayersViewHolder, position: Int) {
        holder.bind(itemViewModels[position])
    }

    fun updateItems(items: List<ItemViewModel>?) {
        itemViewModels = items ?: emptyList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemViewModels.size
    }

}

class LayersViewHolder(
    private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(itemViewModel: ItemViewModel) {
        binding.setVariable(BR.itemViewModel, itemViewModel)
    }
}
