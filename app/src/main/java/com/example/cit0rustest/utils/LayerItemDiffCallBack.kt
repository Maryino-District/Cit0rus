package com.example.cit0rustest.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.cit0rustest.vm.ItemViewModel
import com.example.cit0rustest.vm.LayerViewModel
//проверка/сравнение обновленных и старых элементов списка
class LayerItemDiffCallBack(
val oldList: List<ItemViewModel>,
var newList: List<ItemViewModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return if((oldItem is LayerViewModel) && (newItem is LayerViewModel)) {
            oldItem.name == newItem.name

        } else {
            false
        }
    }

}