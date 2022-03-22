package com.example.cit0rustest.ViewModel

import com.example.cit0rustest.R

class LayerViewModel(
    val name: String,
    var transparency: Int,
    var elementsCount: Int,
    var zoomCount: Int,
    var syncDate: Int
) : ItemViewModel {

    override val layoutId: Int
        get() = R.layout.item_layer

    override val viewType: Int
        get() = 2
}
