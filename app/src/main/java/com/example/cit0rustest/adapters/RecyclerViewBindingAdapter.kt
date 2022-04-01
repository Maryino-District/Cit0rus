package com.example.cit0rustest

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseMethod
import androidx.recyclerview.widget.RecyclerView
import com.example.cit0rustest.adapters.LayersRecyclerVIewAdapter
import com.example.cit0rustest.vm.ItemViewModel


@BindingAdapter("itemViewModels")
fun bindItemViewModels(recyclerView: RecyclerView, itemViewModels: List<ItemViewModel>?) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateItems(itemViewModels)
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): LayersRecyclerVIewAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is LayersRecyclerVIewAdapter) {
        recyclerView.adapter as LayersRecyclerVIewAdapter
    } else {
        val layersRecyclerVIewAdapter = LayersRecyclerVIewAdapter()
        recyclerView.adapter = layersRecyclerVIewAdapter
        layersRecyclerVIewAdapter
    }
}



