package com.example.cit0rustest.vm

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.cit0rustest.R

class LayerViewModel(
    @get:Bindable var name: String,
    var transparency: Int,
    var elementsCount: Int,
    var zoomCount: Int,
    var syncDate: Int
) : BaseObservable(), ItemViewModel {

    override val layoutId: Int
        get() = R.layout.item_layer

    override val viewType: Int
        get() = 2



}
