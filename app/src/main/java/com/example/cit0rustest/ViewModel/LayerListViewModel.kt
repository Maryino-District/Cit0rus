package com.example.cit0rustest.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cit0rustest.Model.Layer

class LayerListViewModel : ViewModel() {
    val data: LiveData<List<ItemViewModel>>
        get() = _data
    private val _data  = MutableLiveData<List<ItemViewModel>> (
        listOf<ItemViewModel>(
            LayerViewModel(
                "Делян",
                40,
                5,
                16,
                4
            ),
            LayerViewModel(
                "Делян",
                40,
                5,
                16,
                4
            ),
            LayerViewModel(
                "Делян",
                40,
                5,
                16,
                4
            ),
            LayerViewModel(
                "Делян",
                40,
                5,
                16,
                4
            ),
            GroupViewModel(
                "groooppa"
            )
        ))//вместо репы

}