package com.example.cit0rustest.vm

import android.graphics.Color
import android.icu.util.LocaleData
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.ColorRes
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class LayerListViewModel(state : SavedStateHandle) : ViewModel() {

    companion object {
        private val KEY = "key"
    }

    var isSearchButtonOn = false


    var visibilityState: Int = 1

    private val savedStateHandle = state

    val data: LiveData<List<ItemViewModel>>
        get() = _data
    private val _data =  savedStateHandle.getLiveData<List<ItemViewModel>>(KEY)

    fun saveCurrentData(itemViewModels: MutableLiveData<List<ItemViewModel>>) {
        savedStateHandle.set(KEY, itemViewModels.value)
    }

    init {
        val tmp = MutableLiveData<List<ItemViewModel>>(
            listOf<ItemViewModel>(//пока что вместо репы
                LayerViewModel(
                    "Слой 1",
                    40,
                    5,
                    16..17,
                    "12.12.12",
                    false,
                    0,
                    true,
                    true,

                ),
                LayerViewModel(
                    "Слой 2",
                    40,
                    5,
                    16..17,
                    "12.12.12",
                    false,
                    1,
                    true,
                    true,

                ),
                LayerViewModel(
                    "Слой 3",
                    40,
                    5,
                    16..17,
                    "12.12.12",
                    false,
                    1,
                    true,
                    true,
                ),
                LayerViewModel(
                    "Слой 4",
                    40,
                    5,
                    16..17,
                    "12.12.12",
                    false,
                    1,
                    true,
                    true,
                )
            )
        )
        saveCurrentData(tmp)
    }


    fun testSave(list: List<ItemViewModel>) {
        _data.value = list
        savedStateHandle.set(KEY, _data.value)
    }


    fun onSearch() {
        isSearchButtonOn = !isSearchButtonOn
    }

}