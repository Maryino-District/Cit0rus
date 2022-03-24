package com.example.cit0rustest.vm

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.cit0rustest.R

class GroupViewModel (
    @Bindable val name: String
    ) : BaseObservable(), ItemViewModel {

    override val layoutId: Int
        get() = R.layout.item_group
    override val viewType: Int
        get() = 1

}