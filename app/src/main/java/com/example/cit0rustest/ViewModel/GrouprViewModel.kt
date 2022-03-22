package com.example.cit0rustest.ViewModel

import com.example.cit0rustest.R

class GroupViewModel (groupName: String) : ItemViewModel {

    override val layoutId: Int
        get() = R.layout.item_group
    override val viewType: Int
        get() = 1

}