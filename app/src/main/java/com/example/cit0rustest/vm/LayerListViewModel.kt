package com.example.cit0rustest.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LayerListViewModel : ViewModel() {
    val data: LiveData<List<ItemViewModel>>
        get() = _data
    private val _data  = MutableLiveData<List<ItemViewModel>> (
        listOf<ItemViewModel>(
            LayerViewModel(
                "0",
                40,
                5,
                16,
                4
            ),
            LayerViewModel(
                "1",
                40,
                5,
                16,
                4
            ),
            LayerViewModel(
                "2",
                40,
                5,
                16,
                4
            ),
            GroupViewModel(
                "groooppa"
            ),
            LayerViewModel(
                "3",
                40,
                5,
                16,
                4
            ),
            LayerViewModel(
                "4",
                40,
                5,
                16,
                4
            ),
            GroupViewModel(
                "groooppa"
            )
        )
    )//вместо репы

}