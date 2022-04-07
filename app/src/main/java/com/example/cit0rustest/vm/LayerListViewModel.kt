package com.example.cit0rustest.vm

import android.graphics.Color
import android.icu.util.LocaleData
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.*
import com.example.cit0rustest.BR
import com.example.cit0rustest.repository.LayerDataProvider

class LayerListViewModel() : ViewModel() {

    //livedata of recyclerview
    val data: LiveData<List<ItemViewModel>>
        get() = _data
    private val _data =  MutableLiveData<List<ItemViewModel>>(emptyList())

    //livedatas of BottomBar
    val isAddButtonOn: LiveData<Boolean>
        get() = _isAddButtonOn
    private val _isAddButtonOn =  MutableLiveData<Boolean>(false)

    val isSearchButtonOn: LiveData<Boolean>
        get() = _isSearchButtonOn
    private val _isSearchButtonOn =  MutableLiveData<Boolean>(false)

    val isRemoveButtonOn: LiveData<Boolean>
        get() = _isRemoveButtonOn
    private val _isRemoveButtonOn =  MutableLiveData<Boolean>(false)

    val isDragButtonOn: LiveData<Boolean>
        get() = _isDragButtonOn
    private val _isDragButtonOn =  MutableLiveData<Boolean>(false)

    val switchState: LiveData<Int>
        get() = _switchState
    private val _switchState =  MutableLiveData<Int>(1)

    private val reserveSwitchStates: MutableMap<String, Boolean> = mutableMapOf()

    //temporarily instead of a repository
    init {
        _data.value = LayerDataProvider().getLayersListData()
    }



    fun onAddButtonClicked() {
        _isAddButtonOn.apply { value = !value!! }
    }

    fun onSearchButtonClicked() {
        _isSearchButtonOn.apply { value = !value!! }
    }

    fun onRemoveButtonClicked() {
        _isRemoveButtonOn.apply { value = !value!! }
    }

    fun onDragButtonClicked() {
        _isDragButtonOn.apply { value = !value!! }
        for (value in data.value.orEmpty()){
            if (value is LayerViewModel) value.isDragable = !value.isDragable
        }
        //livedata will not update its values with the same set of elements
        _data.apply {
            val tmp = value
            value = emptyList()
            value = tmp
        }
    }

    fun changeSwitchStates(){
        when(increaseGlobalSwitchStateFlag()) {
            1 -> {
                restoreSwitchStates()
            }
            2 -> {
                saveSwitchStates()
                setAllSwitchOff()
            }
            else -> setAllSwitchOn()
        }
    }

    fun increaseGlobalSwitchStateFlag() : Int {
        val crab: Int = switchState.value ?: 1
        _switchState.value = crab % 3 + 1
        return _switchState.value ?: 0
    }

    fun restoreSwitchStates() {
        for (value in data.value.orEmpty()){
            if (value is LayerViewModel){
                value.isSwitchOn = reserveSwitchStates[value.name] ?: false
            }
        }
        //livedata will not update its values with the same set of elements
        _data.apply {
            val tmp = value
            value = emptyList()
            value = tmp
        }
    }

    fun saveSwitchStates() {
        for (value in data.value.orEmpty()){
            if (value is LayerViewModel){
                reserveSwitchStates[value.name] = value.isSwitchOn
            }
        }
    }

    fun setAllSwitchOff() {
        for (value in data.value.orEmpty()){
            if (value is LayerViewModel) value.isSwitchOn = false
        }
        //livedata will not update its values with the same set of elements
        _data.apply {
            val tmp = value
            value = emptyList()
            value = tmp
        }
    }

    fun setAllSwitchOn() {
        for (value in data.value.orEmpty()){
            if (value is LayerViewModel) value.isSwitchOn = true
        }
        //livedata will not update its values with the same set of elements
        _data.apply {
            val tmp = value
            value = emptyList()
            value = tmp
        }
    }


}