package com.example.cit0rustest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.cit0rustest.BR
import com.example.cit0rustest.R
import com.example.cit0rustest.databinding.ItemLayerBinding
import com.example.cit0rustest.vm.*

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
        println("111")
        return LayersViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemViewModels[position]
        if (!viewTypeToLayoutId.containsKey(item.viewType)) {
            viewTypeToLayoutId[item.viewType] = item.layoutId
        }
        println("222")

        return item.viewType
    }

    override fun onBindViewHolder(holder: LayersViewHolder, position: Int) {
        holder.bind(itemViewModels[position])
        holder.itemView.setOnClickListener {
            (itemViewModels[position] as? LayerViewModel)?.apply {
                isExpand = !isExpand
            } //проверку бы
            notifyItemChanged(position)
        }

        println("333")//
    }

    override fun getItemCount(): Int {
       return itemViewModels.size
    }


    fun updateItems(items: List<ItemViewModel>?) {
        itemViewModels = items ?: emptyList()
        notifyDataSetChanged()
        println("444")

    }


}

class LayersViewHolder(
    private val binding: ViewDataBinding

) : RecyclerView.ViewHolder(binding.root) {
    fun bind(itemViewModel: ItemViewModel) {
        binding.setVariable(BR.itemViewModel, itemViewModel)
        (binding as? ItemLayerBinding)?.subItem?.apply {
            if ((itemViewModel as LayerViewModel).isExpand) {
                visibility = View.VISIBLE
            } else {
                visibility = View.GONE
            }
        }
        println("1aa")
    }

}
