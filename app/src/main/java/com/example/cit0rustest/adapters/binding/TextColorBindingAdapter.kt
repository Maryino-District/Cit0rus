package com.example.cit0rustest.adapters

import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter

@BindingAdapter("android:textColor")
fun mytextColor(view: TextView, @ColorInt color: Int) {
    view.setTextColor(color)
}