package com.example.parayo.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.parayo.base.BaseViewModel

class MainViewModel @ViewModelInject constructor() : BaseViewModel() {

    private val _productRegistration = MutableLiveData<Boolean>()
    val productRegistration: LiveData<Boolean> get() = _productRegistration

    override fun onClick(type: String, model: Any) {
        when (type) {
            "registration" -> _productRegistration.value = model as Boolean
        }
    }
}