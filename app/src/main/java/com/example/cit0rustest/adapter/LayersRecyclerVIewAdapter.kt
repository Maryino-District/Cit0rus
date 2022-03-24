package com.example.cit0rustest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.cit0rustest.vm.ItemViewModel
import com.example.cit0rustest.BR
import com.example.cit0rustest.R
import com.example.cit0rustest.vm.GroupViewModel
import com.example.cit0rustest.vm.LayerListViewModel
import com.example.cit0rustest.vm.LayerViewModel

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
        //Log.d("tatag","${binding.}")

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
        println("dddd")//вылетает
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
        println("eee")

        binding.setVariable(BR.itemViewModel, itemViewModel)


        println("eee")
    }
}
