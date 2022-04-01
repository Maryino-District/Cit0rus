package com.example.cit0rustest.vm


import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.cit0rustest.BR

class BarState :BaseObservable(){
    @Bindable var isButtonOn = false

    fun changeButtonState() {
        isButtonOn = !isButtonOn

        notifyPropertyChanged(BR.isButtonOn)
    }
}