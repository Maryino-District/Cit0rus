package com.example.cit0rustest.vm

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.cit0rustest.R

class LayerViewModel(
    @Bindable var name: String,
    @Bindable var transparency: Int,
    @Bindable var elementsCount: Int,
    @Bindable var zoomCount: Int,
    @Bindable var syncDate: Int,
    @Bindable var isExpand: Boolean = false
) : BaseObservable(), ItemViewModel {

    override val layoutId: Int
        get() = R.layout.item_layer

    override val viewType: Int
        get() = 2

}
