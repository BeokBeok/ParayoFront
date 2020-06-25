package com.example.parayo.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    protected val _throwable = MutableLiveData<Throwable>()
    val throwable: LiveData<Throwable> get() = _throwable

    open fun onClick(type: String, model: Any) = Unit
}