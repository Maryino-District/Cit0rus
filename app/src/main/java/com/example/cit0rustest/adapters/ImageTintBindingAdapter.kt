package com.example.cit0rustest

import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter

    @BindingAdapter("app:tint")
    fun setImageTint(view: ImageView, @ColorInt color: Int) {
        view.setColorFilter(color)
}