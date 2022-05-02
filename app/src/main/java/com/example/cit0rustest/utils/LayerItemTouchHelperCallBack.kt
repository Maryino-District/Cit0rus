package com.example.cit0rustest.utils

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView
import com.example.cit0rustest.adapters.LayersRecyclerVIewAdapter
import com.example.cit0rustest.vm.ItemViewModel
import com.example.cit0rustest.vm.LayerListViewModel

//
class LayerItemTouchHelperCallBack(val viewModel: ItemTouchContract) : ItemTouchHelper.SimpleCallback(
    UP or  DOWN or START or END, 0
) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        //val adapter = recyclerView.adapter as LayersRecyclerVIewAdapter
        val from = viewHolder.adapterPosition
        val to = target.adapterPosition
        viewModel.moveItem(from, to)
        //viewModel.data.moveItem(from,to)

        println("---moved----from $from to $to")
       // adapter.submitList(result)

        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
    }

    interface ItemTouchContract {
        fun moveItem(from: Int, to: Int)
    }

}


