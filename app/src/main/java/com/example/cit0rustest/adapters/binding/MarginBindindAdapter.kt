package com.example.cit0rustest.adapters

import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginRight
import androidx.databinding.BindingAdapter

@BindingAdapter("android:layout_marginRight")
fun setMargin(view: View, margin: Int){
    val param = view.layoutParams as ViewGroup.MarginLayoutParams
    param.setMargins(0,0,margin,0)
}