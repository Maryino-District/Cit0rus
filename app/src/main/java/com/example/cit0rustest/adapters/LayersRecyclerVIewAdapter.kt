package com.example.cit0rustest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.*
import com.example.cit0rustest.BR
import com.example.cit0rustest.utils.LayerItemDiffCallBack
import com.example.cit0rustest.vm.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class LayersRecyclerVIewAdapter : RecyclerView.Adapter<LayersViewHolder>() {

    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()
    val mItemViewModels: MutableList<ItemViewModel> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LayersViewHolder {
        println("---oncreateview")

        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?:0,
            parent,
            false
        )
//        val holder = LayersViewHolder(binding)

        return LayersViewHolder(binding)
    }
    //realize drag n droop
    fun moveItem(from: Int, to: Int): MutableList<ItemViewModel> {
        val list = mItemViewModels.toMutableList()
        if (from < to) {
            for (i in from until to) {
                 Collections.swap(list, i, i + 1)
            }
        } else {
            for (i in from downTo  to+1 ) {
                Collections.swap(list, i, i - 1)
            }
        }
        notifyItemMoved(from,to)

        return list
    }
     fun submitList(updatedList: List<ItemViewModel>) {
        println("---sub")

        val differCallBack = LayerItemDiffCallBack(mItemViewModels, updatedList)

        val diffResult = DiffUtil.calculateDiff(differCallBack,true)
      /*  mItemViewModels.clear()
        mItemViewModels.addAll()*/
        mItemViewModels.clear()
        for(items in updatedList) {
            val tmp = Gson().toJson(items)
            if (items is LayerViewModel) {
                mItemViewModels.add(Gson().fromJson(tmp, LayerViewModel::class.java))
            } else {
                mItemViewModels.add(Gson().fromJson(tmp, GroupViewModel::class.java))
            }
        }
        //mItemViewModels.addAll(Gson().fromJson<MutableList<ItemViewModel>>(gson,listOfMyClassObject))
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
        println("---onBindViewHolder")

        println("tag onBindViewHolder positiion is ${position}")
        holder.bind(mItemViewModels[position])
        holder.itemView.setOnClickListener {

            (mItemViewModels[holder.adapterPosition] as? LayerViewModel)?.apply {
                //isExpand = !isExpand
                onExpandeClick(this, !isExpand)
            }
            notifyItemChanged(holder.adapterPosition)
        }

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
    private val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemViewModel: ItemViewModel) {
        binding.setVariable(BR.itemViewModel, itemViewModel)
        println("---bind")

    }
}

