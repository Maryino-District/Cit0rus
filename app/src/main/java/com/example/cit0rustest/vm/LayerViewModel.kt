package com.example.cit0rustest.vm

import android.icu.util.LocaleData
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import androidx.annotation.ColorRes
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.cit0rustest.R
import java.util.*
import com.example.cit0rustest.BR


class LayerViewModel(
    var name: String = "def",
    @get: Bindable var transparency: Int = 5,
    var elementsCount: Int = 0,
    var zoomCount: IntRange = 0..0,
    var syncDate: String = "12.12.12",
    @get: Bindable var isSwitchOn: Boolean = false,
    var isActive: Boolean = true,
    var isDragable: Boolean = false
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

    fun centerToGps(){
        TODO()
    }
}
