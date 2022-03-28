package com.example.cit0rustest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.*
import androidx.recyclerview.widget.ItemTouchHelper.*
import com.example.cit0rustest.BR
import com.example.cit0rustest.R
import com.example.cit0rustest.databinding.ItemLayerBinding
import com.example.cit0rustest.utils.LayerItemDiffCallBack
import com.example.cit0rustest.utils.LayerItemTouchHelperCallBack
import com.example.cit0rustest.vm.*
import java.util.*
import kotlin.collections.ArrayList

class LayersRecyclerVIewAdapter : RecyclerView.Adapter<LayersViewHolder>() {
    //var itemViewModels: List<ItemViewModel> = emptyList()
    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()
    var itemViewModels: List<ItemViewModel> = emptyList()
    private val isDragDropButtonMute = false/*передать результат из панельки-фрагмента снизу
    сохранить ее во вьюмодели*/
    //



    //Создаем анонимный объект колбэка diffutil для dragndrop


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LayersViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?:0,
            parent,
            false
        )
        println("tag oncreateviewholder viewtype is $viewType")
        return LayersViewHolder(binding)

    }

    fun moveItem(from: Int, to: Int): MutableList<ItemViewModel> {

        val list = itemViewModels.toMutableList()
        //list.removeAt(from)
        if (from < to) {
            for (i in from until to) {
                 Collections.swap(list, i, i + 1)
            }
        } else {
            for (i in from downTo  to+1 ) {
                Collections.swap(list, i, i - 1)
            }
        }
        println("внутри мувайтема перед сабмитом")


        val differCallBack = LayerItemDiffCallBack(itemViewModels,list)
        val diffResult = DiffUtil.calculateDiff(differCallBack)
        diffResult.dispatchUpdatesTo(this)
        itemViewModels = list
        notifyItemMoved(from,to)
        //notifyDataSetChanged()

        println("внутри мувайтема после сабмита")
        return list

    }
    override fun getItemViewType(position: Int): Int {
        val item = itemViewModels[position]
        if (!viewTypeToLayoutId.containsKey(item.viewType)) {
            viewTypeToLayoutId[item.viewType] = item.layoutId
        }
        println("tag getitemviewtype viewtype is ${item.viewType}")

        return item.viewType
    }

    override fun onBindViewHolder(holder: LayersViewHolder, position: Int) {
            println("tag onBindViewHolder positiion is ${position}")
        holder.bind(itemViewModels[position])
        holder.itemView.setOnClickListener {
            (itemViewModels[position] as? LayerViewModel)?.apply {
                isExpand = !isExpand
                println("tag onbindviewholder --- expandeble")
            } //проверку бы
            if(isDragDropButtonMute){
                println("tag onbindviewholder --- draganddrop")
            }
            notifyItemChanged(position)
            //notifyDataSetChanged()

        }

        //
    }

    override fun getItemCount(): Int {
        println("tag getitemcount")

        return itemViewModels.size
    }


    fun updateItems(items: List<ItemViewModel>?) {
        itemViewModels = items ?: emptyList()
//        notifyDataSetChanged()
        println("tag updateitems")
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
        println("tag bind in viewholderclass")
    }


}
