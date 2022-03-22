package com.example.cit0rustest.Model

import com.example.cit0rustest.ViewModel.ItemViewModel
import java.util.*

data class Layer (
    val name: String,
    var transparency: Int,
    var elementsCount: Int,
    var zoomCount: Int,
    var syncDate: Int
    )