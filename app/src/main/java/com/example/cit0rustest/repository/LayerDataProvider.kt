package com.example.cit0rustest.repository

import com.example.cit0rustest.vm.GroupViewModel
import com.example.cit0rustest.vm.ItemViewModel
import com.example.cit0rustest.vm.LayerListViewModel
import com.example.cit0rustest.vm.LayerViewModel

class LayerDataProvider {
    fun getLayersListData(): List<ItemViewModel> {
        return listOf<ItemViewModel> (
            LayerViewModel(
                "Слой 1",
                2,
                5,
                16..17,
                "12.12.12",
                false,
                true,
                false
            ),
            LayerViewModel(
                "Слой 2",
                2,
                5,
                16..17,
                "12.12.12",
                true,
                true,
                false,

                ),
            LayerViewModel(
                "Слой 3",
                2,
                5,
                16..17,
                "12.12.12",
                false,
                false,
                false,
            ),
            GroupViewModel("Общие слои"),
            LayerViewModel(
                "Слой 4",
                2,
                5,
                16..17,
                "12.12.12",
                true,
                true,
                false,
            ),
            LayerViewModel(
                "Слой 5",
                2,
                5,
                16..17,
                "12.12.12",
                true,
                true,
                false,
            ),
            LayerViewModel(
                "Слой 6",
                2,
                5,
                16..17,
                "12.12.12",
                true,
                true,
                false,
            ),
            LayerViewModel(
                "Слой 7",
                2,
                5,
                16..17,
                "12.12.12",
                true,
                true,
                false,
            ),
            LayerViewModel(
                "Слой 8",
                2,
                5,
                16..17,
                "12.12.12",
                true,
                true,
                false,
            ),

            LayerViewModel("name 1",
            0,
                0,
                0..2,
                "21.04.22",
                true,
                false,
                false
            ),
            LayerViewModel("name 2",
                5,
                0,
                0..2,
                "13.12.22",
                true,
                true,
                false
            ),
            GroupViewModel("группа"
            ),
            LayerViewModel("name 3",
                5,
                0,
                0..2,
                "13.12.22",
                true,
                true,
                false
            ),
            LayerViewModel("name 4",
                5,
                0,
                0..2,
                "13.12.22",
                true,
                true,
                false
            ),
            LayerViewModel("name 5",
                5,
                0,
                0..2,
                "13.12.22",
                true,
                true,
                false
            ),
            LayerViewModel("name 6",
                5,
                0,
                0..2,
                "13.12.22",
                true,
                true,
                false
            ),
            LayerViewModel("name 7",
                5,
                0,
                0..2,
                "13.12.22",
                true,
                true,
                false
            ),
            LayerViewModel("name 8",
                5,
                0,
                0..2,
                "13.12.22",
                true,
                true,
                false
            )
        )
    }
}