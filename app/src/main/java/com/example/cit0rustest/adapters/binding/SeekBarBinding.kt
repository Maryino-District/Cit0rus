package com.example.cit0rustest.adapters.binding

import android.widget.SeekBar
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.google.android.material.slider.Slider
import kotlin.math.roundToInt

@InverseBindingAdapter(attribute = "android:value")
fun getSliderValue(slider: Slider) = slider.value.roundToInt()

@BindingAdapter("android:valueAttrChanged")
fun setSliderListeners(slider: Slider, attrChange: InverseBindingListener) {
   slider.addOnChangeListener { _, _, _ ->
      attrChange.onChange()
   }
}

@BindingAdapter("android:value")
fun setFloatValue(slider: Slider, value: Int) {
   slider.value = value.toFloat()
}