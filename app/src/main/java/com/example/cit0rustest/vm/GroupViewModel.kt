package com.example.cit0rustest.vm

import com.example.cit0rustest.R

class GroupViewModel (
    val name: String
    ) : ItemViewModel {

    override val layoutId: Int
        get() = R.layout.item_group
    override val viewType: Int
        get() = 1

}