package com.example.cit0rustest.vm

import android.icu.util.LocaleData
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.ColorRes
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.cit0rustest.R
import java.util.*
import com.example.cit0rustest.BR


class LayerViewModel(
     @get: Bindable var name: String,
     @get: Bindable var transparency: Int = 0,
     @get: Bindable var elementsCount: Int = 0,
     @get: Bindable var zoomCount: IntRange = 0..0,
     @get: Bindable var syncDate: String,
     @get: Bindable var isSwitchOn: Boolean = false,
     @get: Bindable var globalSwitchState: Int  = 0,
     @get: Bindable var isActive: Boolean = true,
     @get: Bindable var isDragable: Boolean = false
) : BaseObservable(), ItemViewModel {

    override val layoutId: Int
        get() = R.layout.item_layer

    override val viewType: Int
        get() = 2


    @get:Bindable
    var isExpand: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.expand)
        }


    fun onExpandeClick(newExpand: Boolean) {
        isExpand = newExpand
        notifyPropertyChanged(BR.expand)
    }





}
