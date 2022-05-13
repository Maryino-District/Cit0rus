package com.example.cit0rustest.vm


import com.example.cit0rustest.R
import java.text.FieldPosition


data class LayerViewModel(
    var name: String = "def",
    var transparency: Int = 5,
    var elementsCount: Int = 0,
    var zoomCount: IntRange = 0..0,
    var syncDate: String = "12.12.12",
    var isSwitchOn: Boolean = false,
    var isActive: Boolean = true,
) : ItemViewModel {

    override val layoutId: Int
        get() = R.layout.item_layer

    override val viewType: Int
        get() = 2


    var isDragable: Boolean = false
        set(value) {
            if (field != value) {
                println("----binding DRAAGABLE")
                field = value
            }
        }

    var isExpand: Boolean = false
        set(value) {
            if (field != value) {
                field = value
            }
        }

    fun onExpandeClick(item: LayerViewModel, status: Boolean ) {
        isExpand = status
        LayerListViewModel().onExpandeClick(item, status)
    }

    fun centerToGps(){

    }
}
