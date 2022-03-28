package com.example.cit0rustest.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LayerListViewModel : ViewModel() {

    val data: LiveData<List<ItemViewModel>>
        get() = _data
    private val _data  = MutableLiveData<List<ItemViewModel>> (
        listOf<ItemViewModel>(//пока что вместо репы
            LayerViewModel(
                "Слой 1",
                40,
                5,
                16,
                4
            ),
            LayerViewModel(
                "Слой 2",
                40,
                5,
                16,
                4
            ),
            LayerViewModel(
                "Слой 3",
                40,
                5,
                16,
                4
            ),
            GroupViewModel(
                "Общие слои"
            ),
            LayerViewModel(
                "Слой 4 ",
                40,
                5,
                16,
                4
            ),
            LayerViewModel(
                "Слой 5",
                40,
                5,
                16,
                4
            ),

        )
    )

}